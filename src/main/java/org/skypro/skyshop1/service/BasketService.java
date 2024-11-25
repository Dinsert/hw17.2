package org.skypro.skyshop1.service;

import java.util.List;
import java.util.UUID;
import org.skypro.skyshop1.model.basket.BasketItem;
import org.skypro.skyshop1.model.basket.UserBasket;
import org.springframework.stereotype.Service;

@Service
public class BasketService {

    private final ProductBasket productBasket;
    private final StorageService storageService;

    public BasketService(ProductBasket productBasket, StorageService storageService) {
        this.productBasket = productBasket;
        this.storageService = storageService;
    }

    public void add(UUID id) {
        if (storageService.getProductById(id).isEmpty()) {
            throw new IllegalArgumentException();
        }
        productBasket.add(id);
    }

    public UserBasket getUserBasket() {
        List<BasketItem> items = productBasket.getAllProductsByBasket().entrySet()
                                              .stream()
                                              .map(e -> (new BasketItem(storageService.getProductMap().get(e.getKey()), e.getValue())))
                                              .toList();
        UserBasket userBasket = new UserBasket(items);
        userBasket.calculateTotal();
        return userBasket;
    }
}
