package com.example.demo.model;

import com.example.demo.entity.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

// модель для обмена данными между сервером и клиентом

public class User {
    private String username;
    private Long id;

    private List<Todo> todos;

    public static User convertModel(UserEntity userEntity) {
        User user = new User();
        user.setId(userEntity.getId());
        user.setUsername(userEntity.getUsername());
        user.setTodos(userEntity.getTodos().stream().map(Todo::convertModel).collect(Collectors.toList()));
        return user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Todo> getTodos() {
        return todos;
    }

    public void setTodos(List<Todo> todos) {
        this.todos = todos;
    }
}
