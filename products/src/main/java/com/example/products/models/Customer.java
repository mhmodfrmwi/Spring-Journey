package com.example.products.models;

import jakarta.persistence.Entity;

@Entity
public class Customer extends User {

    private double balance;
    public Customer(){
        super();
    }
    public Customer( double balance) {
        super();
        this.balance = balance;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
