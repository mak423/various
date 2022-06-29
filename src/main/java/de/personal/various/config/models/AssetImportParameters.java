package de.personal.various.config.models;

import de.personal.various.config.enums.AssetType;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Defines configuration for importing a project
 * @author Mahjabeen
 */

@Data
@AllArgsConstructor
public class AssetImportParameters {
    private String name;
    private String description;
    private AssetType assetType;
    private String root;
}
