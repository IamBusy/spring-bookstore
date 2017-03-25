package com.william.repository;

import com.william.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by william on 17/3/24.
 */
public interface ProductRepository extends MongoRepository<Product,String> {

    List<Product> findByCategoryId(@Param("categoryId") String categoryId);
}
