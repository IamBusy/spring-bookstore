package com.william.controller;

import com.william.model.Product;
import com.william.repository.ProductRepository;
import com.william.repository.ProductSearchRepository;
import com.william.service.ProductService;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by william on 17/3/24.
 */
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @Autowired
    private ProductSearchRepository productSearchRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Product> getAllProducts()
    {
        return service.findAll();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Product show(@PathVariable String id)
    {
        return service.show(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Product create(@RequestBody Product product)
    {
        productSearchRepository.save(product);
        return service.create(product);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Product update(@PathVariable String id, @RequestBody Product product)
    {
        product.setId(id);
        return service.update(product);
    }

    @RequestMapping("recommendation")
    public List<Product> recommendation() {
        List<Product> products = service.findAll();
        if(products.size() < 6)
            return products;
        return products.subList(0,6);
    }

    @RequestMapping(value = "/search/{key}", method = RequestMethod.GET)
    public List<Product> search(@PathVariable String key) {

        QueryStringQueryBuilder builder=new QueryStringQueryBuilder(key);
        Iterable<Product> searchResult = productSearchRepository.search(builder);
        Iterator<Product> iterator = searchResult.iterator();
        List<Product> res = new ArrayList<>();
        while(iterator.hasNext()){
            res.add(iterator.next());
            //System.out.println(iterator.next());
        }
        return res;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public Product destroy(@PathVariable String id)
    {
        return service.destroy(id);
    }
}
