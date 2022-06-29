package de.personal.various.dao.edges.models;

import com.arangodb.springframework.annotation.Edge;
import com.arangodb.springframework.annotation.From;
import com.arangodb.springframework.annotation.To;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * This class defines relationship between any 2 collections in ArangoDB
 * @param <T1> child element
 * @param <T2> parent element
 * @author mahjabeen
 */
@Data
@AllArgsConstructor
@Edge("asset_edges")
public class ChildOf<T1, T2> {
    @From
    private T1 child;

    @To
    private T2 parent;
}
