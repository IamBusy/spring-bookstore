package com.william.service.impl;

import com.william.model.Order;
import com.william.model.OrderProduct;
import com.william.model.Product;
import com.william.model.User;
import com.william.repository.OrderRepository;
import com.william.service.OrderService;
import com.william.utils.MessageProducer;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.jms.Destination;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by william on 17/3/25.
 */
@Service
public class MongoOrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository repository;
    @Autowired
    private MessageProducer producer;

    @Value("${jms.orders.create}")
    private String processCreationQue;

    @Override
    public Order create(User user, List<OrderProduct> products) {
        products = new ArrayList<>();
        user.setId("this is userId");

        Destination destination = new ActiveMQQueue(processCreationQue);
        Map<String,Object> payload = new HashMap<String,Object>();
        payload.put("userId",user.getId());
        payload.put("products",products);
        producer.sendMessage(destination,payload);


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
