package com.william.service.impl;

import com.william.model.User;
import com.william.repository.UserRepository;
import com.william.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by william on 17/3/24.
 */
@Service
public class MongoUserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User create(User user) {
        User uu = userRepository.findByUsername(user.getUsername());
        System.out.print(uu);
        if(uu == null) {
            return userRepository.insert(user);
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User show(String id) {
        return userRepository.findOne(id);
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public User destroy(String id) {
        User user = userRepository.findOne(id);
        userRepository.delete(id);
        return user;
    }
    @Override
    public List<User> findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username,password);
    }
}
