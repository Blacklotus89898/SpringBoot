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

    @NotEmpty
    private String status;

    // // NEEDS Default constructor for hibernate
    public Task() {
        // This is the default (no-argument) constructor
    }

    public Task(@NotEmpty String name, String status) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.status = status;

    }

    public Task(String id, @NotEmpty String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    // GETTERS AND SETTERS FOR ALL FIELDS MUST EXIST FOR HIBERNATE TO WORK
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
