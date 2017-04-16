package com.william.service;

import com.william.model.Category;
import com.william.model.Product;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by william on 17/3/25.
 */
@Transactional
public interface ProductService {
    Product create(Product product);
    @Cacheable(value = "product",keyGenerator = "wiselyKeyGenerator")
    Product show(String id);
    Product update(Product product);
    @Cacheable(value = "products",keyGenerator = "wiselyKeyGenerator")
    List<Product> findAll(Category category);
    List<Product> findAll();
    Product destroy(String id);
}
