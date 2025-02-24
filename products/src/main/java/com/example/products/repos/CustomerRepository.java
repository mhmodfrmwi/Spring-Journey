package com.example.products.repos;


import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.products.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    Page<Customer> findByAccountNumber(String accountNumber,Pageable pageable);
    Page<Customer>  findByFirstName(String firstName,Pageable pageable);
    Page<Customer> findByLastName(String lastName,Pageable pageable);
    Page<Customer> findByDepartment(String department,Pageable pageable);
}
