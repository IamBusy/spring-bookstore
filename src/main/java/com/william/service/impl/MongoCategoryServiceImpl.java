package com.william.service.impl;

import com.william.model.Category;
import com.william.repository.CategoryRepository;
import com.william.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by william on 17/3/25.
 */
@Service
public class MongoCategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository repository;
    @Override
    public Category create(Category category) {
        return repository.insert(category);
    }

    @Override
    public Category show(String id) {
        return repository.findOne(id);
    }

    @Override
    public Category update(Category category) {
        return repository.save(category);
    }

    @Override
    public List<Category> findAll() {
        Sort sort = new Sort(Sort.Direction.ASC,"order");
        return repository.findAll(sort);
    }

    @Override
    public Category destroy(String id) {
        Category category = repository.findOne(id);
        repository.delete(id);
        return category;
    }
}
