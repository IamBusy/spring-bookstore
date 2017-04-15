package com.william.repository;

import com.william.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by william on 17/3/24.
 */
public interface OrderRepository extends MongoRepository<Order,String> {
    List<Order> findByUserId(@Param("userId") String userId);
}
