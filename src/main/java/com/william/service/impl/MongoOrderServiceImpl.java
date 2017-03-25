package com.william.service.impl;

import com.william.model.Order;
import com.william.model.OrderProduct;
import com.william.model.Product;
import com.william.model.User;
import com.william.repository.OrderRepository;
import com.william.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by william on 17/3/25.
 */
@Service
public class MongoOrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository repository;

    @Override
    public Order create(User user, List<OrderProduct> products) {
        Order order = new Order();
        order.setUser(user);
        order.setProducts(products);
        return repository.insert(order);
    }

    @Override
    public Order show(String id) {
        return repository.findOne(id);
    }

    @Override
    public List<Order> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Order> findAll(User user) {
        return repository.findByUserId(user.getId());
    }

    @Override
    public Order update(Order order) {
        return repository.save(order);
    }

    @Override
    public Order destroy(String id) {
        Order order = repository.findOne(id);
        repository.delete(id);
        return order;
    }
}
