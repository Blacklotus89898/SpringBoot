package com.example.demo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.Task.Status;

@Service
public class TaskService {

    private Map<String, Task> db = new HashMap<>() {
        {
            put("1", new Task("Koko", Status.Completed));
            put("2", new Task("2", "Lol", Status.Completed));
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
