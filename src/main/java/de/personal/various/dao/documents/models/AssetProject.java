package de.personal.various.dao.documents.models;

import java.time.LocalDateTime;

import com.arangodb.springframework.annotation.Document;
import lombok.Data;

@Data
@Document("assets_project")
public class AssetProject extends CommonProperties {

	String path;
	String description;
	LocalDateTime imported_at;
	public static int classProp;

	public AssetProject() {}

	public AssetProject(String name, String path, String description, LocalDateTime imported_at) {
		this.name = name;
		this.path = path;
		this.description = description;
		this.imported_at = imported_at;
	}

	@Override
	public String getProjectKey() {
		return getKey();
	}
}

