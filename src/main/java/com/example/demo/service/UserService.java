package com.example.demo.service;

import com.example.demo.entity.UserEntity;
import com.example.demo.exceptions.UserAlreadyExistException;
import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

// Сервис работает с конкретной логикой

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public UserEntity registration(UserEntity user) throws UserAlreadyExistException {
        if (userRepo.findByUsername(user.getUsername()) != null) {
            throw new UserAlreadyExistException("Пользователь с таким именем уже существует");
        }
        return userRepo.save(user);
    }

    public User getOne(Long id) throws UserNotFoundException {
        Optional<UserEntity> userEntity = userRepo.findById(id);
        if (userEntity.isEmpty()) {
            throw new UserNotFoundException("Пользователь не найден");
        }
        return User.convertModel(userEntity.get());
    }

    public Long delete(Long id) throws UserNotFoundException {
        userRepo.deleteById(id);
        return id;
    }

}
