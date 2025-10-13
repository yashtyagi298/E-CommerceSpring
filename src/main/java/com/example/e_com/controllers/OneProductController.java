package com.example.e_com.controllers;

import com.example.e_com.dtos.CategoryDTO;
import com.example.e_com.dtos.OneProductDTO;
import com.example.e_com.dtos.ProductDto;
import com.example.e_com.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
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

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAllProduct() throws IOException {
                List<CategoryDTO> prod = productService.getAllCategories();
                return ResponseEntity.ok(prod);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OneProductDTO> getOneProductbyId(@PathVariable Long id) throws Exception {
         OneProductDTO result = productService.getOneProduct(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto dto){
         return ResponseEntity.ok(productService.createProduct(dto));
    }

}
