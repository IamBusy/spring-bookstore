package com.william.controller;

import com.william.model.Category;
import com.william.model.Product;
import com.william.repository.CategoryRepository;
import com.william.repository.ProductRepository;
import com.william.service.CategoryService;
import com.william.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by william on 17/3/24.
 */
@RestController
@RequestMapping("/categories")
public class CategoryController {


    @Autowired
    private CategoryRepository repository;
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService service;

    @RequestMapping(method = RequestMethod.POST)
    public Category create(@RequestBody Category category)
    {
        return service.create(category);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Category> getAllCategories()
    {
        return service.findAll();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Category show(@PathVariable String id)
    {
        return service.show(id);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Category update(@PathVariable String id, @RequestBody Category category)
    {
        category.setId(id);
        return service.create(category);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public Category destroy(@PathVariable String id)
    {
        return service.destroy(id);
    }

    @RequestMapping("/{id}/products")
    public List<Product> findAllProducts(@PathVariable String id)
    {
        return productService.findAll(repository.findOne(id));
    }


}
