package com.example.demo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.NotEmpty;

// model
public class Photo{
    private String id;

    @NotEmpty
    private String filename;

    @JsonIgnore
    private byte[] data;


    public Photo(String id, String filename) {
        //TODO Auto-generated constructor stub
        this.id = id;
        this.filename = filename;
    }
    public String getId() {
        return this.id;
    }
    public void setId(String string) {
        this.id = string;
    }
    
    public String getFileName() {
        return this.filename;
    }
    public void setFileName(String filename) {
         this.filename = filename;
    }
    
    public byte[] getData() {
        return this.data;
    }
    public void setData(byte[] data) {
         this.data = data;
    }
}