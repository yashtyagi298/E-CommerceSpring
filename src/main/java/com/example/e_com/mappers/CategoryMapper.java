package com.example.e_com.mappers;

import com.example.e_com.dtos.CategoryDTO;
import com.example.e_com.entity.Category;
import com.example.e_com.entity.Product;

import java.util.List;

public class CategoryMapper {
    public static CategoryDTO toDto(Category category){
        return CategoryDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
    public static Category toEnity(CategoryDTO dto){
        return Category.builder()
                .name(dto.getName())
                .build();
    }
}
