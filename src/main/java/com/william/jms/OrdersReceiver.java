package com.william.jms;

import com.william.model.Order;
import com.william.model.OrderProduct;
import com.william.model.User;
import com.william.repository.OrderRepository;
import com.william.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Map;

/**
 * Created by william on 15/04/2017.
 */
@Component
public class OrdersReceiver {
    @Autowired
    private UserService userService;
    @Autowired
    private OrderRepository orderRepository;


    @JmsListener(destination = "orders.process.create")
    @Transactional
    public void processCreation(Map<String,Object> payload){
        String userId = (String) payload.get("userId");
        List<OrderProduct> products = (List<OrderProduct>)payload.get("products");
        User user = userService.show(userId);
        Order order = new Order();
        order.setUser(user);
        order.setProducts(products);
        orderRepository.save(order);
    }
}
