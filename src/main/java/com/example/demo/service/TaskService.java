package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public void createTask(Task task) {
        taskRepository.save(task); //will need a usecase folder for business logic
    }

    public Task getTaskById(String id) {
        Optional<Task> task = taskRepository.findById(id);
        if (task.isPresent()) {
            return task.get();
        }
        return null;
    }

    public void updateTaskById(Task task) {
        Optional<Task> t = taskRepository.findById(task.getId());
        Task tt = t.get();
        tt.setName(task.getName());
        tt.setStatus(task.getStatus());
        taskRepository.save(tt);
    }

    public void delteTaskById(String id) {
        taskRepository.deleteById(id);
    }

}
