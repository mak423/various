package de.personal.various.dao.documents.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.arangodb.springframework.repository.ArangoRepository;

import de.personal.various.dao.documents.models.AssetStructures;

/**
 * This repository allows DB operations among Folder Nodes
 * @author Mahjabeen
 */
@Repository
public interface AssetStructureRepository extends ArangoRepository <AssetStructures, String> {

}
