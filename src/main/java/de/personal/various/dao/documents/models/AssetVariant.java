package de.personal.various.dao.documents.models;

import com.arangodb.springframework.annotation.Document;

import de.personal.various.dao.enums.VariantType;
import lombok.Data;

@Data
@Document("asset_variants")
public class AssetVariant extends CommonProperties {

	private int variantOrder;

	VariantType variantType;

	public AssetVariant(String name, String projectKey, int variantOrder, VariantType variantType) {
		this.name = name;
		this.projectKey = projectKey;
		this.variantOrder = variantOrder;
		this.variantType = variantType;
	}
}
