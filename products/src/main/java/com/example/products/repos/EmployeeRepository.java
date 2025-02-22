package com.example.products.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.products.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    
}
