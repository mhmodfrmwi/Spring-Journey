package com.example.products.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.products.models.Product;


public interface ProductRepository extends JpaRepository<Product,Integer> {
}