package com.example.demo.repository;

// src/main/java/com/example/demo/repository/UserRepository.java

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Task;

public interface TaskRepository extends JpaRepository<Task, String> {

    void updateTaskById(String id, Task task);
    // You can add custom queries here if needed
}
