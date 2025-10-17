package com.example.e_com.controllers;

import com.example.e_com.dtos.CategoryDTO;
import com.example.e_com.dtos.OneProductDTO;
import com.example.e_com.dtos.ProductDto;
import com.example.e_com.dtos.ProductWithCategoryDto;
import com.example.e_com.exception.CategoryNotFoundException;
import com.example.e_com.exception.ProductNotFoundException;
import com.example.e_com.exception.ProductWithCategoryException;
import com.example.e_com.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/categories/product")
public class OneProductController {
//    private final  IOneProductService iOneProductService;
    private final ProductService productService;

    public OneProductController(@Qualifier("ProductService") ProductService productService) {
        this.productService = productService;
    }

//    @GetMapping
//    public ResponseEntity<List<CategoryDTO>> getAllProduct() throws IOException {
////                List<CategoryDTO> prod = productService.getAllCategories();
////                return ResponseEntity.ok(prod);
//        return null;
//    }

    @GetMapping("/{id}")
    public ResponseEntity<OneProductDTO> getOneProductbyId(@PathVariable Long id)  {
         OneProductDTO result = productService.getOneProduct(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto dto) {
         return ResponseEntity.ok(productService.createProduct(dto));
    }

    @GetMapping("/{id}/details")
    public ResponseEntity<ProductWithCategoryDto> getProductWithCategory(@PathVariable long id) {
        return ResponseEntity.ok(productService.getProductWithCategory(id));
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> productNotFounndException (ProductNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(ProductWithCategoryException.class)
    public ResponseEntity<String> productWithCategoryException(ProductWithCategoryException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

//    @ExceptionHandler(CategoryNotFoundException.class)
//    public ResponseEntity<String> categoryNotFoundException(CategoryNotFoundException ex){
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
//    }

}
