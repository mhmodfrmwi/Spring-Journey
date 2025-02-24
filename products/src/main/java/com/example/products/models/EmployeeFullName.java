package com.example.products.models;

public class EmployeeFullName {
    private final String fullName;

    public EmployeeFullName(String firstName, String lastName) {
        this.fullName = firstName + " " + lastName; 
    }

    public String getFullName() {
        return fullName;
    }
}