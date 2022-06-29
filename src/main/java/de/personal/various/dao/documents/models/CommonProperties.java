package de.personal.various.dao.documents.models;

import com.arangodb.springframework.annotation.Relations;
import de.personal.various.dao.edges.models.ChildOf;
import org.springframework.data.annotation.Id;

import lombok.Data;

import java.util.Collection;

@Data
public class CommonProperties extends GenericElement {
	@Id
	String key;
	String name;
	String projectKey;

	@Relations(edges = ChildOf.class, lazy = true, direction = Relations.Direction.INBOUND)
	private Collection<CommonProperties> elements;
}
