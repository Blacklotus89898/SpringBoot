package com.example.demo.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Act
// Call the method you want to test
public class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    public TaskServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllTasks() {
        // Arrange
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("1", "Task 1"));
        tasks.add(new Task("2", "Task 2"));
        when(taskRepository.findAll()).thenReturn(tasks);

        // Act
        List<Task> result = taskService.getAllTasks();

        // Assert
        assertEquals(tasks, result);
    }

    @Test
    public void testCreateTask() {
        // Arrange
        Task task = new Task("1", "Task 1");

        // Act
        taskService.createTask(task);

        // Assert
        verify(taskRepository, times(1)).save(task);
    }

    @Test
    public void testGetTaskById() {
        // Arrange
        Task task = new Task("1", "Task 1");
        when(taskRepository.findById("1")).thenReturn(Optional.of(task));

        // Act
        Task result = taskService.getTaskById("1");

        // Assert
        assertEquals(task, result);
    }

    @Test
    public void testUpdateTaskByName() {
        // Arrange
        Task task = new Task("1", "Task 1");



        // Act
        taskService.createTask(task);
        Task t = taskService.getTaskByName("1");
        t.setName("newName");
        taskService.updateTaskById(t);

        // Assert
        verify(taskRepository, times(1)).save(task);
    }

    @Test
    public void testDeleteTaskById() {
        // Arrange
        String taskId = "1";

        // Act
        taskService.deleteTaskById(taskId);

        // Assert
        verify(taskRepository, times(1)).deleteById(taskId);
    }
}
