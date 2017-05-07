package com.william.aspect;

import com.william.model.Order;
import com.william.model.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * Created by william on 07/05/2017.
 */
@Aspect
@Component
public class LogAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(public * com.william.controller.OrderController.create(..))")
    public void createOrder (){}

    @Pointcut("execution(public * com.william.controller.AuthController.signin(..))")
    public void userSignin (){}

    @Before("createOrder()")
    public void beforeCreateOrder(JoinPoint joinPoint) {
        logger.info("create order start:");
        Object[] params = joinPoint.getArgs();
        Order order = (Order)params[0];
        logger.info(order.toString());
    }


    @Before("userSignin()")
    public void beforeUserSignin(JoinPoint joinPoint) {
        logger.info("signin start:");
        Object[] params = joinPoint.getArgs();
        User user = (User)params[0];
        logger.info(user.toString());
    }

    @AfterReturning(value = "userSignin()",returning = "token")
    public void afterUserSignin(JoinPoint joinPoint, Object token) {
        logger.info("signin end");
        logger.info(token.toString());
    }

}
