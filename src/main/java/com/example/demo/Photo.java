package com.example.demo;


public class Photo{
    private String id;
    private String filename;


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
    public String setFileName() {
        return this.filename;
    }
}