package de.personal.various.dao.documents.repositories;

import java.util.List;

import com.arangodb.springframework.annotation.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.arangodb.springframework.repository.ArangoRepository;

import de.personal.various.dao.documents.models.AssetVariant;

/**
 * This repository allows DB operation among Variants
 * 
 * @author Mahjabeen
 */
@Repository
public interface AssetVariantRepository extends ArangoRepository<AssetVariant, String> {
}
