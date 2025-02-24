package com.example.products.models;

import org.springframework.beans.factory.annotation.Value;

public interface EmployeeFullNameView {
     @Value("#{target.firstName + ' ' + target.lastName}")
    String getFullName();
}