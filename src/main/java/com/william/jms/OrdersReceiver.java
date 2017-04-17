package com.william.jms;

import com.william.model.Order;
import com.william.model.OrderProduct;
import com.william.model.Product;
import com.william.model.User;
import com.william.repository.OrderRepository;
import com.william.service.ProductService;
import com.william.service.UserService;
import com.william.utils.DateHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
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
    @Autowired
    private ProductService productService;


    @JmsListener(destination = "orders.process.create")
    @Transactional
    public void processCreation(Map<String,Object> payload){
        String userId = (String) payload.get("userId");
        List<Map<String,String>> products = (List<Map<String,String>>)payload.get("products");
        List<OrderProduct> pds = new ArrayList<>();

        BigDecimal total = new BigDecimal(0);
        for(int i=0;i<products.size();i++)
        {
            Map<String,String> item = products.get(i);
            Product product = productService.show(item.get("id"));
            Integer quantity = Integer.valueOf(item.get("quantity"));
            for(int j=0;j<quantity;j++)
            {
                total = total.add(product.getPrice());
            }
            OrderProduct orderProduct = new OrderProduct(product);
            orderProduct.setQuantity(quantity);
            pds.add(orderProduct);
        }

        User user = userService.show(userId);
        Order order = new Order();
        order.setUser(user);
        order.setProducts(pds);
        order.setTotal(total);
        order.setCreatedAt(new Date());
        orderRepository.save(order);
    }
}
