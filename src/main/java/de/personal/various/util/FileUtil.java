package de.personal.various.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.time.LocalDateTime;
import java.time.ZoneId;

import lombok.experimental.UtilityClass;

/**
 * This class is helper class which have different helper functions
 * 
 * @author Mahjabeen
 */
@UtilityClass
public class FileUtil {
	/**
	 * this function converts file contents to String
	 * 
	 * @param file takes file as input
	 * @return content string will be returned
	 * @throws IOException
	 */
	public static String readFilesAsString(File file) throws IOException {
		String data = "";
		data = new String(Files.readAllBytes(Paths.get(file.getAbsolutePath())));
		return data;
	}

	/**
	 * This function converts file time to Local Time
	 * 
	 * @param fileTime the fileTime object to be converted
	 * @return converted local date time
	 */
	public static LocalDateTime convertTime(FileTime fileTime) {
		return LocalDateTime.ofInstant(fileTime.toInstant(), ZoneId.systemDefault());
	}

	/**
	 * this function gives us the relative path between parent and child file
	 * 
	 * @param parentFile
	 * @param childFile
	 * @return
	 */
	public static String getRelativePath(File parentFile, File childFile) {
		String parentPath = parentFile.getAbsolutePath();
		String childPath = childFile.getAbsolutePath();
		return new File(parentPath).toURI().relativize(new File(childPath).toURI()).getPath();
	}
	
	/**
	 * Method to check if a string is a file path.
	 * @param path
	 * @return
	 */
	public static boolean isValidPath(String path) {
		File file = new File(path);
		return file.exists();
	}
}