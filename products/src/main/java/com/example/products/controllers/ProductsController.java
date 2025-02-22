package com.example.products.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.products.models.Product;
import com.example.products.repos.ProductRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class ProductsController {

    @Autowired
    private ProductRepository productRepository;
    public ProductsController() {
        
    }
    @GetMapping("/products")
    public List<Product> getProducts() {
        return productRepository.findAll();
    }
    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable("id") int id) {
        return productRepository.findById(id).orElse(null);
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product) {
        productRepository.save(product);
        return product;
    }
    
    @PutMapping("/products")
    public Product updateProduct( @RequestBody Product updatedProduct) {
        productRepository.save(updatedProduct);
        return updatedProduct;
    }
    
    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable("id") int id) {
        productRepository.deleteById(id);
    }
}