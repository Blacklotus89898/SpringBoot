package com.example.demo.controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.model.Task;
import com.example.demo.service.TaskService;

import jakarta.validation.Valid;

@RestController
public class TaskController {

    @Autowired
    private TaskService TaskService;
    // Alternate way
    // private final TaskService TaskService;
    // public TaskController(TaskService taskService) {
    // this.TaskService = taskService;
    // }

    @GetMapping("tasks")
    public Collection<Task> getTasks() {
        return TaskService.getAllTasks();
    }

    @GetMapping("tasks/{id}")
    public Task getTaskById(@PathVariable String id) {
        Task task = TaskService.getTaskById(id);
        if (task == null) {
            System.out.printf("Task with id <%s> not found \n", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return task;
    }

    @PostMapping("tasks/create")
    public ResponseEntity<Task> createTask(@Valid @RequestBody Task task) {
        TaskService.createTask(task);
        Task createdTask = TaskService.getTaskById(task.getId());
        if (createdTask == null) {
            System.out.printf("Created task <%s> was not found \n", task.toString());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    }

    @GetMapping("tasks/name/{name}")
    public Task getTaskByName(@PathVariable String name) {
        Collection<Task> tasks = TaskService.getAllTasks();
        Task task = null;
        for (Task t : tasks) {
            if (t.getName().equals(name)) {
                task = t;
            }
        }
        if (task == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return task;
    }

}
