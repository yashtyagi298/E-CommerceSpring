package com.example.e_com.controllers;

import com.example.e_com.dtos.CategoryDTO;
import com.example.e_com.services.RestTemplateFakeStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/resttemplateproduct")
public class RestTemplateCategoryController {
    private final RestTemplateFakeStore restTemplateFakeStore;



    public RestTemplateCategoryController(RestTemplateFakeStore restTemplateFakeStore) {
        this.restTemplateFakeStore = restTemplateFakeStore;
    }

    @GetMapping
    List<CategoryDTO> getAllProduct() throws IOException {
        return restTemplateFakeStore.getAllCategories();
    }

}
