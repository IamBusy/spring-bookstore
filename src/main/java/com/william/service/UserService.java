package com.william.service;

import com.william.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by william on 17/3/24.
 */
@Transactional
public interface UserService {
    User create(User user);
    User show(String id);
    User update(User user);
    List<User> findAll();
    User destroy(String id);

}
