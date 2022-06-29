package de.personal.various.testsuite.prepare.service.impl;

import de.personal.various.config.enums.AssetType;
import de.personal.various.config.models.AssetImportParameters;
import de.personal.various.dao.documents.models.*;
import de.personal.various.dao.documents.models.AssetProject;
import de.personal.various.prepare.service.impl.FileSystemImportServiceImpl;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * This is the test class for file system import service
 *
 * @author mahjabeen
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FileSystemImportServiceIntegrationTest {
    private static final String PROJECT_ROOT = "./src/test/resources/Project/Project1";
    private static final String PROJECT_NAME = "test project";
    private static final String PROJECT_DES = "for integration test";
    private AssetImportParameters parameters;
    private AssetProject savedProject;

    @Before
    public void init() {
        parameters = new AssetImportParameters("test project", "for integration test", AssetType.SRC, PROJECT_ROOT);
    }

    @Autowired
    private FileSystemImportServiceImpl fileSystemImportService;

    /**
     * This test creates nodes in DB. This is ignored if not needed
     * @throws IOException
     */
    @Test
    @Ignore
    public void testFileImporter() throws IOException {
        savedProject = fileSystemImportService.processProjectAsset(parameters);
        AssetProject retrievedProject = fileSystemImportService.getAsset(savedProject.getKey());

        assertEquals(savedProject.getKey(), retrievedProject.getKey());
        assertEquals(PROJECT_NAME, retrievedProject.getName());
        assertEquals(PROJECT_DES, retrievedProject.getDescription());
        assertEquals(PROJECT_ROOT, retrievedProject.getPath());

        Collection<CommonProperties> elements = retrievedProject.getElements();
        assertEquals(3, elements.size());
    }
}
