package com.example.e_com.gateway;

import com.example.e_com.dtos.OneProductDTO;

import java.io.IOException;

public interface IGetProduct {
    OneProductDTO getProductById(Long id) throws IOException;
}
