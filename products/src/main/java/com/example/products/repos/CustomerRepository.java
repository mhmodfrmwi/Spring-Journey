package com.example.products.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.products.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
