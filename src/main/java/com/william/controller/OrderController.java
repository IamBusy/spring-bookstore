package com.william.controller;

import com.william.model.Order;
import com.william.model.OrderProduct;
import com.william.model.Product;
import com.william.model.User;
import com.william.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by william on 17/3/25.
 */
@RestController
public class OrderController {
    @Autowired
    private OrderService service;


    @RequestMapping(method = RequestMethod.GET)
    public List<Order> getAllProducts()
    {
        return service.findAll();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Order show(@PathVariable String id)
    {
        return service.show(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Order create(@RequestBody List<OrderProduct> products)
    {
        return service.create(new User(),products);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Order update(@PathVariable String id, @RequestBody Order product)
    {
        product.setId(id);
        return service.update(product);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public Order destroy(@PathVariable String id)
    {
        return service.destroy(id);
    }
}
