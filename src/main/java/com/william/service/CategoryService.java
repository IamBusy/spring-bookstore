package com.william.service;

import com.william.model.Category;

import java.util.List;

/**
 * Created by william on 17/3/25.
 */
public interface CategoryService {
    Category create(Category category);
    Category show(String id);
    Category update(Category category);
    List<Category> findAll();
    Category destroy(String id);
}
