package com.example.products.models;

import jakarta.persistence.Entity;

@Entity
public class Employee extends User {
    private String position;
    private String salary;
    public Employee() {
        super();
    }
    public Employee(String position, String salary){
        super();
        this.position = position;
        this.salary = salary;
    }
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public String getSalary() {
        return salary;
    }
    public void setSalary(String salary) {
        this.salary = salary;
    }
}

