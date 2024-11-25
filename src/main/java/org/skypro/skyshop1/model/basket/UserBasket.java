package org.skypro.skyshop1.model.basket;

import java.util.List;

public class UserBasket {

    private final List<BasketItem> basketItems;
    private int total;

    public UserBasket(List<BasketItem> basketItems) {
        this.basketItems = basketItems;
    }

    public void calculateTotal() {
        total = basketItems.stream()
                           .map(basketItem -> (basketItem.getProduct().getPrice() * basketItem.getCount()))
                           .mapToInt(Integer::intValue)
                           .sum();
    }

    public List<BasketItem> getBasketItems() {
        return basketItems;
    }

    public int getTotal() {
        return total;
    }
}
