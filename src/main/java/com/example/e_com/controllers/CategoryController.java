package com.example.e_com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @GetMapping
    public String getCategoryName(){
        return "electronics";
    }
    @GetMapping("/count")
    public int getTotalCategory(){
        return 5;
    }

    @DeleteMapping
    public String deleteCategory(){
        return "Category deleted";
    }
}
