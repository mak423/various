package de.personal.various.dao.documents.models;

import com.arangodb.springframework.annotation.Document;
import lombok.Data;

@Data
@Document("asset_structures")
public class AssetStructures extends CommonProperties {

	String relativePath;

	public AssetStructures(String name, String relativePath, String projectKey) {
		this.name = name;
		this.relativePath = relativePath;
		this.projectKey = projectKey;
	}
}
