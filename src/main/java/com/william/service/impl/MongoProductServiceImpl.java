package com.william.service.impl;

import com.william.model.Category;
import com.william.model.Product;
import com.william.repository.CategoryRepository;
import com.william.repository.ProductRepository;
import com.william.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by william on 17/3/25.
 */
@Service
public class MongoProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository repository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Product create(Product product) {
        return repository.insert(product);
    }

    @Override
    public Product show(String id) {
        Product product = repository.findOne(id);
        product.setCategory(categoryRepository.findOne(product.getCategoryId()));
        return product;
    }

    @Override
    public Product update(Product product) {
        return repository.save(product);
    }

    @Override
    public Product destroy(String id) {
        Product product = this.show(id);
        repository.delete(id);
        return product;
    }

    @Override
    public List<Product> findAll(Category category) {
        List<Product> products = repository.findByCategoryId(category.getId());
        products.forEach(product -> {
            product.setCategory(categoryRepository.findOne(product.getCategoryId()));
        });
        return products;
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = repository.findAll();
        products.forEach(product -> {
            product.setCategory(categoryRepository.findOne(product.getCategoryId()));
        });
        return products;
    }
}
