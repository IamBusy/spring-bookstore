package com.william.controller;

import com.william.model.Order;
import com.william.model.OrderProduct;
import com.william.model.Product;
import com.william.model.User;
import com.william.model.wrapper.OrderWrapper;
import com.william.service.OrderService;
import com.william.service.UserService;
import com.william.utils.JwtUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by william on 17/3/25.
 */
@RequestMapping("/orders")
@RestController
public class OrderController {
    @Autowired
    private OrderService service;
    @Autowired
    private UserService userService;

    @RequestMapping("/test")
    public List<Order>test() {
        String header  = "Bearer 58f47981874c331f61e9d037";
        User user = userService.show(JwtUser.getTokenFromHeader(header));
        user.setPhoto("http://ojiqea97q.bkt.clouddn.com/jianshu/WechatIMG32.jpeg");
        userService.update(user);
        return service.findAll(user);
    }


    @RequestMapping(method = RequestMethod.GET)
    public List<Order> getAllOrders(@RequestHeader String authorization)
    {
        User user = userService.show(JwtUser.getTokenFromHeader(authorization));
        return service.findAll(user);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Order show(@PathVariable String id)
    {
        return service.show(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Order create(@RequestBody Order order,@RequestHeader String authorization)
    {
        User user = userService.show(JwtUser.getTokenFromHeader(authorization));
        return service.create(user,order.getProducts());
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
