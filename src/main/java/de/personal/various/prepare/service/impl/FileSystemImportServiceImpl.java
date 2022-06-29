package de.personal.various.prepare.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDateTime;
import java.util.Optional;

import de.personal.various.dao.documents.models.*;
import de.personal.various.dao.enums.VariantType;
import de.personal.various.dao.documents.repositories.AssetElementRepository;
import de.personal.various.dao.documents.repositories.AssetProjectRepository;
import de.personal.various.dao.documents.repositories.AssetStructureRepository;
import de.personal.various.dao.documents.repositories.AssetVariantRepository;
import de.personal.various.dao.edges.models.ChildOf;
import de.personal.various.dao.edges.repositories.ChildOfRepository;
import de.personal.various.prepare.service.AssetImportService;
import de.personal.various.util.FileUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import de.personal.various.config.models.AssetImportParameters;

/**
 * This is the implementation of the import service
 * 
 * @author Mahjabeen
 */
@Service
@RequiredArgsConstructor
@Qualifier("filesystem")
public class FileSystemImportServiceImpl implements AssetImportService {
	private final AssetElementRepository fileRepository;
	private final AssetStructureRepository folderRepository;
	private final AssetVariantRepository variantRepository;
	private final AssetProjectRepository assetRepository;
	private final ChildOfRepository childOfRepository;

	/**
	 * Used for maintaining variant order in an asset project
	 */
	private int variantOrder = 0;

	/**
	 * Imports a project from import configuration
	 * @param importConfig
	 * @return project which is created
	 * @throws IOException
	 */
	@Override
	public AssetProject processProjectAsset(AssetImportParameters importConfig) throws IOException {
		AssetProject asset = new AssetProject(importConfig.getName(), importConfig.getRoot(),
				importConfig.getDescription(), LocalDateTime.now());
		assetRepository.save(asset);
		File rootFile = new File(asset.getPath());

		for (File file : rootFile.listFiles()) {
			saveVariant(file, asset);

			// increase variant order value to set next one
			variantOrder++;
		}
		return asset;
	}

	/**
	 * Saves a variant and its sub structure upto asset element in database
	 * @param variant to be saved
	 * @param asset under this asset project the variant will be saved
	 * @throws IOException
	 */
	public void saveVariant(File variant, AssetProject asset) throws IOException {
		if (variant.isDirectory()) {
			AssetVariant variantsNode = new AssetVariant(variant.getName(), asset.getKey(), variantOrder, VariantType.Unprocessed);
			variantRepository.save(variantsNode);

			ChildOf childOf = new ChildOf(variantsNode, asset);
			childOfRepository.save(childOf);

			saveVariantStructure(variant, variant, variantsNode, asset);
		}
	}

	/**
	 * Saves all sub element of a variant in dababase
	 * @param allFile List of all files/folder under root file
	 * @param rootFile parent file
	 * @param parentNode parent node which is saved into database
	 * @param asset asset project under which the variant structure is saved
	 * @throws IOException
	 */
	private void saveVariantStructure(File allFile, File rootFile, GenericElement parentNode, AssetProject asset)
			throws IOException {
		java.io.File[] files = allFile.listFiles();

		if (files != null && files.length > 0) {
			for (File file : files) {
				// Check if the file is a directory
				if (file.isDirectory()) {
					AssetStructures structureNode = createStructureNode(file, rootFile, asset);
					// saving folders into database
					folderRepository.save(structureNode);
					// adding relationship
					ChildOf childOf = new ChildOf(structureNode, parentNode);
					childOfRepository.save(childOf);

					// giving the folder in parameter to save the relationship to its child
					saveVariantStructure(file, rootFile, structureNode, asset);
				} else {
					AssetElement elementNode = createElementNode(file, rootFile, asset);
					// saving files into database
					fileRepository.save(elementNode);
					// adding relationship
					ChildOf childOf = new ChildOf(elementNode, parentNode);
					childOfRepository.save(childOf);

				}
			}
		}
	}

	/**
	 * Create a variant Structure
	 * @param file Structure directory
	 * @param rootFile parent directory of the file
	 * @param asset under this asset project the structure is saved
	 * @return
	 */
	private AssetStructures createStructureNode(File file, File rootFile, AssetProject asset) {
		// Getting file path wrt root file
		String relativePath = FileUtil.getRelativePath(rootFile, file);

		return new AssetStructures(file.getName(), relativePath, asset.getKey());
	}

	/**
	 * Creates an asset element
	 * @param file the disk element which corresponds to the element
	 * @param rootFile parent structure of the element
	 * @param asset under this asset ptoject the element file is saved
	 * @return
	 * @throws IOException
	 */
	private AssetElement createElementNode(File file, File rootFile, AssetProject asset) throws IOException {

		// Separating file name and extension name
		String fileNameWithExtension = file.getName();
		String fileName = fileNameWithExtension.replaceFirst("[.][^.]+$", "");
		String fileExtension = fileNameWithExtension.substring(fileNameWithExtension.lastIndexOf('.'));

		// Getting created Time and modified Time of a file
		BasicFileAttributes attr = Files.readAttributes(Paths.get(file.getAbsolutePath()), BasicFileAttributes.class);
		LocalDateTime createdTime = FileUtil.convertTime(attr.creationTime());
		LocalDateTime modifiedTime = FileUtil.convertTime(attr.lastModifiedTime());

		// Get the whole file as string content
		String content = FileUtil.readFilesAsString(file);

		// Getting file path wrt root file
		String relativePath = FileUtil.getRelativePath(rootFile, file);
		String variantName = rootFile.getName();

		return new AssetElement(fileName, fileNameWithExtension, fileExtension, relativePath, createdTime, modifiedTime, content, variantName,
				asset.getKey(), variantOrder);
	}

	/**
	 * gets an asset project from database
	 * @param key Id to be searched
	 * @return project
	 */
	@Override
	public AssetProject getAsset(String key) {
		Optional<AssetProject> project = assetRepository.findById(key);
		if (project.isPresent()) {
			return project.get();
		}
		return null;
	}
}
