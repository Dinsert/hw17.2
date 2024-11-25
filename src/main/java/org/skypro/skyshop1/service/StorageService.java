package org.skypro.skyshop1.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import org.skypro.skyshop1.model.article.Article;
import org.skypro.skyshop1.model.product.DiscountedProduct;
import org.skypro.skyshop1.model.product.FixPriceProduct;
import org.skypro.skyshop1.model.product.Product;
import org.skypro.skyshop1.model.product.SimpleProduct;
import org.skypro.skyshop1.model.search.Searchable;
import org.springframework.stereotype.Service;

@Service
public class StorageService {

    private final Map<UUID, Product> productMap;
    private final Map<UUID, Article> articleMap;

    public StorageService() {
        this.productMap = new HashMap<>();
        this.articleMap = new HashMap<>();
        testData();
    }

    public Collection<Product> getAllProducts() {
        return productMap.values();
    }

    public Collection<Article> getAllArticles() {
        return articleMap.values();
    }

    public Collection<Searchable> getAllSearchable() {
        Collection<Searchable> result = new ArrayList<>();
        result.addAll(productMap.values());
        result.addAll(articleMap.values());
        return result;
    }

    public Map<UUID, Product> getProductMap() {
        return productMap;
    }

    public Optional<Product> getProductById(UUID id) {
        return Optional.ofNullable(productMap.get(id));
    }

    private void testData() {
        List<Product> productList = new ArrayList<>(List.of(
                new SimpleProduct("Course Java", 200_000, UUID.randomUUID()),
                new SimpleProduct("Course Java", 200_000, UUID.randomUUID()),
                new SimpleProduct("Course Python", 100_000, UUID.randomUUID()),
                new SimpleProduct("Course Python", 100_000, UUID.randomUUID()),
                new SimpleProduct("Course Python", 100_000, UUID.randomUUID()),
                new FixPriceProduct("Course С#", UUID.randomUUID()),
                new DiscountedProduct("Course Kotlin", 95_000, 95, UUID.randomUUID())
        ));
        List<Article> articleList = new ArrayList<>(List.of(
                new Article("Statya0", "Method printf()", UUID.randomUUID()),
                new Article("Statya0", "Method printf()", UUID.randomUUID()),
                new Article("Statya01", "Method printf()", UUID.randomUUID()),
                new Article("Statya012", "Method printf()", UUID.randomUUID()),
                new Article("Statya0123", "General rules language", UUID.randomUUID()),
                new Article("Statya012345", "Base knowledge", UUID.randomUUID())
        ));
        for (Product product : productList) {
            productMap.put(product.getId(), product);
        }
        for (Article article : articleList) {
            articleMap.put(article.getId(), article);
        }
    }
}
