package com.example.demo.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Task;
import com.example.demo.model.Task.Status;
import com.example.demo.repository.TaskRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;
    
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    private Map<String, Task> db = new HashMap<>() {
        {
            put("1", new Task("Koko", "Status.Completed"));
            put("2", new Task("2", "Lol", "Status.Completed"));
        }
    };

    public Map<String, Task> getDb() {
        return db;
    }

    public Task get(String id) {
        return db.get(id);
    }

    public Collection<Task> values() {
        return db.values();
    }

    

}
