package com.example.products.models;

import jakarta.persistence.Entity;

@Entity
public class Customer extends User {
    private String accountNumber;
    private String department;
    private double balance;
    public Customer(){
        super();
    }
    public Customer( double balance, String accountNumber, String department) {
        super();
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.department = department;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
}
