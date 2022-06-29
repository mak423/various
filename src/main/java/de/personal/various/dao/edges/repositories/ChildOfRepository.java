package de.personal.various.dao.edges.repositories;

import com.arangodb.springframework.repository.ArangoRepository;

import de.personal.various.dao.edges.models.ChildOf;

import org.springframework.stereotype.Repository;

/**
 * Allows DB operation of child of relationship
 * @author mahjabeen
 */
@Repository
public interface ChildOfRepository extends ArangoRepository<ChildOf, String> {

}
