package com.example.demo.service;

import com.example.demo.entity.TodoEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.exceptions.TodoNotFoundException;
import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.model.Todo;
import com.example.demo.repository.TodoRepo;
import com.example.demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepo todoRepo;
    @Autowired
    private UserRepo userRepo;

    public Todo createTodo(TodoEntity todoEntity, Long userId) throws UserNotFoundException{
        Optional<UserEntity> userEntity = userRepo.findById(userId);
        if (userEntity.isEmpty()) {
            throw new UserNotFoundException("Пользователь не найден");
        }
        todoEntity.setUser(userEntity.get());
        return Todo.convertModel(todoRepo.save(todoEntity));
    }

    public Todo completeTodo(Long id) throws TodoNotFoundException {
        Optional<TodoEntity> todoEntity = todoRepo.findById(id);
        if (todoEntity.isEmpty()) {
            throw new TodoNotFoundException("Задача не найдена");
        }
        TodoEntity todo = todoEntity.get();
        todo.setCompleted(true);
        return Todo.convertModel(todoRepo.save(todo));
    }
}
