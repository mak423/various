package de.personal.various.dao.documents.models;

import lombok.Data;

/**
 * this class is extended by all nodes(variants, files, folders)
 * so that we can use it as a generic type of all type of nodes
 * @author Mahjabeen
 */
@Data
public class GenericElement {
    private String _class;
}
