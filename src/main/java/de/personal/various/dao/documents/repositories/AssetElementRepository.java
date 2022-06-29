package de.personal.various.dao.documents.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.arangodb.springframework.annotation.Query;
import com.arangodb.springframework.repository.ArangoRepository;

import de.personal.various.dao.documents.models.AssetElement;

/**
 * This repository allows DB operation among File Nodes
 * 
 * @author Mahjabeen
 */
@Repository
public interface AssetElementRepository extends ArangoRepository<AssetElement, String> {
}
