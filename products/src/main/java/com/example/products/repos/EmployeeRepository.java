package com.example.products.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.products.models.Employee;
import com.example.products.models.EmployeeFullName;
import com.example.products.models.EmployeeFullNameView;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    EmployeeFullNameView findByLastName(String lastName);

    @Query("SELECT new com.example.products.models.EmployeeFullName(e.firstName, e.lastName) FROM Employee e")
    List<EmployeeFullName> findAllEmployeeFullNames();
}
