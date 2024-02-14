package com.example.demo.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Task {
    
    @Id
    private String id;
    
    @NotEmpty
    private String name;
    
    private @NotEmpty String status;
    
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


    // // NEEDS Default constructor for hibernate
    public Task() {
        // This is the default (no-argument) constructor
    }

    public Task(@NotEmpty String name, @NotEmpty String status) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.status = status;
    
    }


    public Task(String id, @NotEmpty String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public void setName(String name) {
        this.name = name;
    }

    // public Status getStatus() {
    //     return status;
    // }

    // public void setStatus(Status status) {
    //     this.status = status;
    // }
}
