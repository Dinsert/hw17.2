package org.skypro.skyshop1.model.product;

import static java.util.Objects.isNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Objects;
import java.util.UUID;
import org.skypro.skyshop1.model.search.Searchable;

public abstract class Product implements Searchable {

    private final String nameProduct;
    private final UUID id;

    public Product(String nameProduct, UUID id) {
        checkNameProduct(nameProduct);
        this.nameProduct = nameProduct;
        this.id = id;
    }

    private void checkNameProduct(String nameProduct) {
        if (isNull(nameProduct) || nameProduct.isBlank()) {
            throw new IllegalArgumentException("Неверное имя продукта");
        }
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();

    public String getNameProduct() {
        return nameProduct;
    }

    @JsonIgnore
    @Override
    public String getContentType() {
        return TypeContent.PRODUCT.getType();
    }

    @Override
    public String getName() {
        return nameProduct;
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
        Product product = (Product) o;
        return Objects.equals(nameProduct, product.nameProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nameProduct);
    }
}

