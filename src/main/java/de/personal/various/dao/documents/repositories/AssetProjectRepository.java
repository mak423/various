package de.personal.various.dao.documents.repositories;

import org.springframework.stereotype.Repository;

import com.arangodb.springframework.repository.ArangoRepository;

import de.personal.various.dao.documents.models.AssetProject;

/**
 * This is the repository to interact with projects in database
 * 
 * @author mahjabeen
 */
@Repository
public interface AssetProjectRepository extends ArangoRepository<AssetProject, String> {
}
