package com.example.products.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.products.models.Customer;
import com.example.products.repos.CustomerRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;
    public CustomerController() {
    }

    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }
    @GetMapping("/customers/{id}")  
    public Customer getCustomer(@PathVariable("id") int id) {
        return customerRepository.findById(id).orElse(null);
    }
    @PostMapping("/customers")
    public Customer createCustomer(@RequestBody Customer customer) {
        customerRepository.save(customer);
        return customer;
    }
    @PutMapping("customers/{id}")
    public Customer updateCustomer(@PathVariable int id, @RequestBody Customer customer) {
        Customer existingCustomer = customerRepository.findById(id).orElse(null);
        if(existingCustomer==null){
            return null;
        }
        existingCustomer.setFirstName(customer.getFirstName());
        existingCustomer.setLastName(customer.getLastName());
        existingCustomer.setBalance(customer.getBalance());
        customerRepository.save(existingCustomer);        
        return existingCustomer;
    }
    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(@PathVariable int id) {
        customerRepository.deleteById(id);
    }

    @GetMapping("/customers/search")
    public Page<Customer> searchCustomers(
            @RequestParam(required = false) String accountNumber,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String department,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size){
         Pageable pageable = PageRequest.of(page, size);

        if (accountNumber != null) {
            return customerRepository.findByAccountNumber(accountNumber,pageable);
        } else if (firstName != null) {
                return customerRepository.findByFirstName(firstName, pageable);
        }else if (lastName != null) {
            return customerRepository.findByLastName(lastName,pageable);
        }
         else if (department != null) {
            return customerRepository.findByDepartment(department,pageable);
        }
        return customerRepository.findAll(pageable);
    }
}