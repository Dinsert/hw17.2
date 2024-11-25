package org.skypro.skyshop1.model.article;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Objects;
import java.util.UUID;
import org.skypro.skyshop1.model.product.TypeContent;
import org.skypro.skyshop1.model.search.Searchable;

public class Article implements Searchable {

    private final String title;
    private final String text;
    private final UUID id;

    public Article(String title, String text, UUID id) {
        this.title = title;
        this.text = text;
        this.id = id;
    }

    @JsonIgnore
    @Override
    public String getContentType() {
        return TypeContent.ARTICLE.getType();
    }

    @Override
    public String getName() {
        return title;
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Article article = (Article) o;
        return Objects.equals(title, article.title);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(title);
    }

    @Override
    public String toString() {
        return title + "\n" + text;
    }
}
