package com.william.controller;

import com.william.model.JwtToken;
import com.william.model.User;
import com.william.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by william on 17/04/2017.
 */
@RestController
public class AuthController {
    @Autowired
    private UserService userService;

    @RequestMapping("/signin")
    public JwtToken signin(@RequestBody User user) {
        JwtToken token = new JwtToken();
        List<User> users = userService.findByUsernameAndPassword(user.getUsername(),user.getPassword());
        if(users.size() > 0){
            user = users.get(0);
            token.setToken(user.getId());
            token.setExpired_in(String.valueOf(System.currentTimeMillis()+24*60*60*100));
        }
        return token;
    }

    @RequestMapping("/signup")
    public JwtToken signup(@RequestBody User user) {
        user.setPhoto("http://ojiqea97q.bkt.clouddn.com/jianshu/WechatIMG32.jpeg");
        user = userService.create(user);
        if(user != null)
        {
            JwtToken token = new JwtToken();
            token.setToken(user.getId());
            token.setExpired_in(String.valueOf(System.currentTimeMillis()+24*60*60*100));
            return token;
        }
        return null;
    }

}
