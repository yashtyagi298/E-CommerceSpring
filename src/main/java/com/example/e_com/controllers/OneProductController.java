package com.example.e_com.controllers;

import com.example.e_com.dtos.OneProductDTO;
import com.example.e_com.services.IOneProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/categories/product")
public class OneProductController {
    private final  IOneProductService iOneProductService;
     OneProductController(IOneProductService _iOneProductService){
         this.iOneProductService = _iOneProductService;
     }
    @GetMapping("/{id}")
    public ResponseEntity<OneProductDTO> getOneProductbyId(@PathVariable Long id) throws IOException {
         OneProductDTO result = iOneProductService.getOneProduct(id);
        return ResponseEntity.ok(result);
    }
}
