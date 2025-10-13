package com.example.e_com.controllers;

import com.example.e_com.dtos.CategoryDTO;
import com.example.e_com.services.ICategoryService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private final ICategoryService iCategoryService;

    CategoryController(@Qualifier("FakeStoreCategoryService") ICategoryService  _iCategoryService){
        this.iCategoryService = _iCategoryService;
    }
    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAllCategories() throws IOException {
       List<CategoryDTO> result =  this.iCategoryService.getAllCategories();
           return ResponseEntity.ok(result);
    }
}
