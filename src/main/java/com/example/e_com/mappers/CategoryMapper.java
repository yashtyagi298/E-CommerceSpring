package com.example.e_com.mappers;

import com.example.e_com.dtos.CategoryDTO;
import com.example.e_com.dtos.CategoryWithProductDto;
import com.example.e_com.entity.Category;
import com.example.e_com.entity.Product;

import java.util.List;
import java.util.stream.Collectors;

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

    public static CategoryWithProductDto toCategoryWithProductDto (Category category){
        return CategoryWithProductDto.builder()
                .id(category.getId())
                .name(category.getName())
                .products(category.getProducts().stream().map(ProductMapper::toDto).collect(Collectors.toList()))
                .build();
    }
}
