package org.skypro.skyshop1.model.product;

public enum TypeContent {
    PRODUCT("PRODUCT"), ARTICLE("ARTICLE");
    private String type;

    TypeContent(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
