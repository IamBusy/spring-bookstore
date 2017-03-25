package com.william.service;

import com.william.model.Order;
import com.william.model.OrderProduct;
import com.william.model.Product;
import com.william.model.User;

import java.util.List;

/**
 * Created by william on 17/3/25.
 */
public interface OrderService {
    Order create(User user, List<OrderProduct> products);
    Order show(String id);
    Order update(Order order);
    List<Order> findAll();
    List<Order> findAll(User user);
    Order destroy(String id);
}
