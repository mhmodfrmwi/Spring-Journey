package com.example.products.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.products.models.AppProperties;


@RestController
public class PropertyController {
    @Value("${spring.profiles.active}")
    private String activeProfile;

    @GetMapping("/active-profile")
    public String getAppName() {
        return activeProfile;
    }

    @Autowired
    private AppProperties appProperties;

    @GetMapping("/app-property/{key}")
    public String getProperty(@PathVariable String key) {
        return appProperties.getName();
    }
}