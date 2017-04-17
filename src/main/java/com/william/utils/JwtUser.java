package com.william.utils;

import com.william.model.User;
import com.william.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by william on 17/04/2017.
 */
@Component
public class JwtUser {
    @Autowired
    private static UserService userService;
    public static String getTokenFromHeader(String authorization) {
        return authorization.substring(7);
    }
}
