package com.example.e_com.services;

import com.example.e_com.dtos.CategoryDTO;
import com.example.e_com.entity.Category;
import com.example.e_com.mappers.CategoryMapper;
import com.example.e_com.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service("CategoryService")
public class CategoryService implements ICategoryService{


    private final CategoryRepository categoryRepository ;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
         List<CategoryDTO> categories =  categoryRepository.findAll()
                 .stream()
                 .map(CategoryMapper::toDto)
                 .collect(Collectors.toList());
         return categories;
    }

    @Override
    public  CategoryDTO createCategory(CategoryDTO Cdto ) throws IOException {
        Category category = CategoryMapper.toEnity(Cdto);
        Category saved = categoryRepository.save(category);
        return CategoryMapper.toDto(saved);
     }

    @Override
    public CategoryDTO getCategoryByName(String name) throws Exception {
          Category find = categoryRepository.findByName(name).orElseThrow(()->new Exception("invalid name"));
          return CategoryMapper.toDto(find);
    }
}
