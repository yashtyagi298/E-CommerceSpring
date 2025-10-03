package com.example.e_com.services;

import com.example.e_com.dtos.CategoryDTO;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public interface ICategoryService {
    List<CategoryDTO> getAllCategories() throws IOException;
}
