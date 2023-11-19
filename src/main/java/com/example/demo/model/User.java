package com.example.demo.model;

import com.example.demo.entity.UserEntity;

public class User {
    private String username;
    private Long id;

    public static User convertModel(UserEntity userEntity) {
        User user = new User();
        user.setId(userEntity.getId());
        user.setUsername(userEntity.getUsername());
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
}
