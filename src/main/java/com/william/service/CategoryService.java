package com.william.service;

import com.william.model.Category;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by william on 17/3/25.
 */
@Transactional
public interface CategoryService {
    Category create(Category category);
    @Cacheable(value = "category",keyGenerator = "wiselyKeyGenerator")
    Category show(String id);
    Category update(Category category);
    @Cacheable(value = "categories",keyGenerator = "wiselyKeyGenerator")
    List<Category> findAll();
    Category destroy(String id);
}
