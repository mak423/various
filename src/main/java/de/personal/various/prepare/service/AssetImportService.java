package de.personal.various.prepare.service;


import java.io.IOException;

import org.springframework.stereotype.Service;

import de.personal.various.config.models.AssetImportParameters;
import de.personal.various.dao.documents.models.AssetProject;


/**
 * This service will import all the variants and other related tasks to import
 * @author Mahjabeen
 */
@Service
public interface AssetImportService {
    
    /**
     * Imports a project from import configuration
     * @param configuration
     * @return project which is created
     * @throws IOException
     */
    AssetProject processProjectAsset(AssetImportParameters configuration) throws Exception;

    /**
     * gets an asset project from database
     * @param key Id to be searched
     * @return project
     */
    AssetProject getAsset(String key);
}
