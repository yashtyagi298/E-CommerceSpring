package com.example.e_com.services;

import com.example.e_com.dtos.OneProductDTO;
import com.example.e_com.dtos.ProductDto;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;


public interface IOneProductService  {
    OneProductDTO getOneProduct(Long id) throws Exception;
    ProductDto createProduct(ProductDto dto);
}
