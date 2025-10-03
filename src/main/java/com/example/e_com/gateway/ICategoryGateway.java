package com.example.e_com.gateway;

import com.example.e_com.dtos.CategoryDTO;

import java.io.IOException;
import java.util.List;

public interface ICategoryGateway {
       List<CategoryDTO> getAllCategories() throws IOException;
}
