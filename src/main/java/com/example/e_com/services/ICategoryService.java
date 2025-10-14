package com.example.e_com.services;

import com.example.e_com.dtos.CategoryDTO;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public interface ICategoryService {
    List<CategoryDTO> getAllCategories() throws IOException;
    CategoryDTO createCategory(CategoryDTO dto) throws IOException;

    CategoryDTO getCategoryByName(String name) throws Exception;
}
