package com.example.e_com.services;

import com.example.e_com.dtos.OneProductDTO;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public interface IOneProductService {
    OneProductDTO getOneProduct(Long id) throws IOException;
}
