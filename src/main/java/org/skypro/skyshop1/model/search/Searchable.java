package org.skypro.skyshop1.model.search;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.UUID;

public interface Searchable {

    default boolean searchTerm(String term) {
        return getName().contains(term);
    }

    String getContentType();

    String getName();

    UUID getId();

    @JsonIgnore
    default String getStringRepresentation() {
        return getName() + "-" + getContentType();
    }

}
