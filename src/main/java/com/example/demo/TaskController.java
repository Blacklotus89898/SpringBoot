package com.example.demo;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.model.Task;

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
        // return TaskService.getDb().values();
        return TaskService.getAllTasks();
    }

    @GetMapping("tasks/{id}")
    public Task getTaskById(@PathVariable String id) {
        Task task = TaskService.get(id);
        return task;
    }

    @GetMapping("tasks/name/{name}")
    public Task getTaskByName(@PathVariable String name) {
        Collection<Task> tasks = TaskService.values();
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
