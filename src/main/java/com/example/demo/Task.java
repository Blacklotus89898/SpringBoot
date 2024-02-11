package com.example.demo;

import java.util.UUID;

import jakarta.validation.constraints.NotEmpty;

public class Task {
    private String id;
    
    @NotEmpty
    private String name;
    
    private @NotEmpty Status status;
    
    public enum Status {
        Created,
        Completed
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Task(@NotEmpty String name, @NotEmpty Status status) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.status = status;
    
    }


    public Task(String id, @NotEmpty String name, Status status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
