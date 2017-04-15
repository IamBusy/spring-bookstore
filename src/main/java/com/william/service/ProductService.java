package com.william.service;

import com.william.model.Category;
import com.william.model.Product;

import java.util.List;

/**
 * Created by william on 17/3/25.
 */
public interface ProductService {
    Product create(Product product);
    Product show(String id);
    Product update(Product product);
    List<Product> findAll(Category category);
    List<Product> findAll();
    Product destroy(String id);
}