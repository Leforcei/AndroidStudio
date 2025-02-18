package com.example.employeesapp;

public class Employee {
    private final String name;
    private final String position;
    private final int photoResId;

    public Employee(String name, String position, int photoResId) {
        this.name = name;
        this.position = position;
        this.photoResId = photoResId;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public int getPhotoResId() {
        return photoResId;
    }
}