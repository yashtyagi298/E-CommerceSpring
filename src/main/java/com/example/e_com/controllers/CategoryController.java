package com.example.e_com.controllers;

import com.example.e_com.dtos.CategoryDTO;
import com.example.e_com.dtos.CategoryWithProductDto;
import com.example.e_com.exception.CategoryNotFoundException;
import com.example.e_com.exception.CategoryWithProductException;
import com.example.e_com.services.ICategoryService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
//    private final ICategoryService iCategoryService;
//
//    CategoryController(@Qualifier("FakeStoreCategoryService") ICategoryService  _iCategoryService){
//        this.iCategoryService = _iCategoryService;
//    }

    private final ICategoryService iCategoryService;

    public CategoryController(@Qualifier("CategoryService") ICategoryService iCategoryService) {
        this.iCategoryService = iCategoryService;
    }

    @GetMapping
    public ResponseEntity<?> getAllCategories(@RequestParam(required = false) String name) throws Exception {
        if (name != null && !name.isBlank()) {
            return ResponseEntity.ok(iCategoryService.getCategoryByName(name));
        } else {
            return ResponseEntity.ok(iCategoryService.getAllCategories());
        }
    }

    @GetMapping("/{name}")
    public ResponseEntity<CategoryDTO> getCategoryByName(@PathVariable String name) throws Exception {
        return ResponseEntity.ok(iCategoryService.getCategoryByName(name));
    }


    @GetMapping("/{id}/products")
    public ResponseEntity <CategoryWithProductDto> getCategoryWithProduct(@PathVariable long id) throws Exception {
        return ResponseEntity.ok(iCategoryService.getCategoryWithProduct(id ));
    }

    @PostMapping
    public ResponseEntity< CategoryDTO> createCategory(@RequestBody CategoryDTO dto) throws IOException {
       return ResponseEntity.ok(iCategoryService.createCategory(dto));
    }

//    @ExceptionHandler(CategoryNotFoundException.class)
//    ResponseEntity<String > categoryNotFoundException(CategoryNotFoundException ex){
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
//
//    }

    @ExceptionHandler(CategoryWithProductException.class)
    ResponseEntity<String> categoryWithProductException(CategoryWithProductException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
