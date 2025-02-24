package com.example.products.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.products.models.Employee;
import com.example.products.models.EmployeeFullName;
import com.example.products.models.EmployeeFullNameView;
import com.example.products.models.EmployeeView;
import com.example.products.repos.EmployeeRepository;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;
    public EmployeeController() {
    }
    @GetMapping("/employees")
    public List<EmployeeFullName> getAllEmployeeFullNames() {
        return employeeRepository.findAllEmployeeFullNames();
    }
    
    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return employeeRepository.findById(id).orElse(null);
    }
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }
    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable int id,@RequestBody Employee updatedEmployee) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        if (employee != null) {
            employee.setFirstName(updatedEmployee.getFirstName());
            employee.setLastName(updatedEmployee.getLastName());
            employee.setPosition(updatedEmployee.getPosition()); 
            employee.setSalary(updatedEmployee.getSalary());     
            return employeeRepository.save(employee);
        }
        return null;
    }
    @GetMapping("/employees/search/{lastName}")
    public EmployeeFullNameView getEmployeeByPosition(@PathVariable String lastName) {
        return employeeRepository.findByLastName(lastName);
    }
    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable int id) {
        employeeRepository.deleteById(id);
    }
}