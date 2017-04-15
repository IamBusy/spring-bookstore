package com.william.repository;

import com.william.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by william on 17/3/24.
 */
public interface CategoryRepository extends MongoRepository<Category,String> {
}
