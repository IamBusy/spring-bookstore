package com.william.controller;

import com.william.model.User;
import com.william.repository.UserRepository;
import com.william.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by william on 17/3/24.
 */
@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.GET)
    public List<User> getAllUsers()
    {
        return service.findAll();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public User show(@PathVariable String id)
    {
        return service.show(id);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public User update(@PathVariable String id, @RequestBody User user)
    {
        user.setId(id);
        return service.update(user);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public User destroy(@PathVariable String id)
    {
        return service.destroy(id);
    }


}
