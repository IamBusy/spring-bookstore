package com.william.repository;

import com.william.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends MongoRepository<User,String> {
    User findByUsername(@Param("username") String username);

}