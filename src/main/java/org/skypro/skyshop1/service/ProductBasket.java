package org.skypro.skyshop1.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@SessionScope
@Component
public class ProductBasket {

    private final Map<UUID, Integer> productBasket;
    private Integer count = 1;

    public ProductBasket() {
        this.productBasket = new HashMap<>();
    }

    public void add(UUID id) {
        if (productBasket.containsKey(id)) {
            count++;
        }
        productBasket.put(id, count);
    }

    public Map<UUID, Integer> getAllProductsByBasket() {
        return Collections.unmodifiableMap(productBasket);
    }
}
