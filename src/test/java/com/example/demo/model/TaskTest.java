package com.example.demo.model;
import org.junit.jupiter.api.Test;

import com.example.demo.model.Task;

import jakarta.validation.Validation;
import jakarta.validation.ValidatorFactory;

import static org.junit.jupiter.api.Assertions.*;

import javax.xml.validation.Validator;

public class TaskTest {

    private final ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = (Validator) validatorFactory.getValidator();

    @Test
    public void testTaskConstructor() {
        // Arrange
        String name = "Task 1";
        String status = "Pending";

        // Act
        Task task = new Task(name, status);

        // Assert
        assertNotNull(task.getId());
        assertEquals(name, task.getName());
        assertEquals(status, task.getStatus());
    }

    @Test
    public void testTaskIdSetter() {
        // Arrange
        Task task = new Task();

        // Act
        task.setId("1");

        // Assert
        assertEquals("1", task.getId());
    }

    @Test
    public void testTaskNameSetter() {
        // Arrange
        Task task = new Task();

        // Act
        task.setName("Task 1");

        // Assert
        assertEquals("Task 1", task.getName());
    }

    @Test
    public void testTaskStatusSetter() {
        // Arrange
        Task task = new Task();

        // Act
        task.setStatus("Pending");

        // Assert
        assertEquals("Pending", task.getStatus());
    }

    // @Test
    // public void testTaskValidation() {
    //     // Arrange
    //     Task task = new Task("", "");

    //     // Act
    //     var violations = validator.validate(task);

    //     // Assert
    //     assertFalse(violations.isEmpty());
    // }
}