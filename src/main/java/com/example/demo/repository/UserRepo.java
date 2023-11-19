package com.example.demo.repository;

import com.example.demo.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

// репозиторий работает с БД

public interface UserRepo extends CrudRepository<UserEntity, Long> {
    UserEntity findByUsername (String username);
}
