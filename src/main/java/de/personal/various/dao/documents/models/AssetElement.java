package de.personal.various.dao.documents.models;

import java.time.LocalDateTime;

import com.arangodb.springframework.annotation.Document;
import lombok.Data;

@Data
@Document("asset_elements")
public class AssetElement extends CommonProperties {

	String fullName;
	String extension;
	String relativePath;
	LocalDateTime imported_at;
	LocalDateTime modified_at;
	String content;
	String variantName;
	int variantOrder;
	
	public AssetElement(String name, String fullName, String extension, String relativePath, LocalDateTime imported_at,
			LocalDateTime modified_at, String content, String variantName, String projectKey, int variantOrder) {
		this.name = name;
		this.fullName = fullName;
		this.extension = extension;
		this.relativePath = relativePath;
		this.imported_at = imported_at;
		this.modified_at = modified_at;
		this.content = content;
		this.variantName = variantName;
		this.projectKey = projectKey;
		this.variantOrder = variantOrder;
	}
}
