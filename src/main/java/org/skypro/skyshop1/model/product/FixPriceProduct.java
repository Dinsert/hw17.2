package org.skypro.skyshop1.model.product;

import java.util.UUID;

public class FixPriceProduct extends Product {

    private static final int FIX_PRICE = 10_000;

    public FixPriceProduct(String nameProduct, UUID id) {
        super(nameProduct,id);
    }

    @Override
    public int getPrice() {
        return FIX_PRICE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return getNameProduct() + ":" + " Фиксированная цена " + FIX_PRICE;
    }
}
