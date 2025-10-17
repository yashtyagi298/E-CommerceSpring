package com.example.e_com.services;

import com.example.e_com.dtos.CategoryDTO;
import com.example.e_com.dtos.OneProductDTO;
import com.example.e_com.dtos.ProductDto;
import com.example.e_com.dtos.ProductWithCategoryDto;
import com.example.e_com.entity.Category;
import com.example.e_com.entity.Product;
import com.example.e_com.exception.CategoryNotFoundException;
import com.example.e_com.exception.ProductNotFoundException;
import com.example.e_com.exception.ProductWithCategoryException;
import com.example.e_com.mappers.ProductMapper;
import com.example.e_com.repository.CategoryRepository;
import com.example.e_com.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service("ProductService")
public class ProductService implements IOneProductService {
    private final ProductRepository repo;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository repo, CategoryRepository categoryRepository) {
        this.repo = repo;
        this.categoryRepository = categoryRepository;
    }


    @Override
    public OneProductDTO getOneProduct(Long id) {
        return repo.findById(id)
                .map(ProductMapper::toOneProduct)
                .orElseThrow(()->new ProductNotFoundException("This Product Id  =  "+id+" Not found "));
    }

    @Override
    public ProductDto createProduct(ProductDto dto)  {
        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(()-> new CategoryNotFoundException(" Invalid Category which gives you in product details "));

       Product save =  repo.save(ProductMapper.toEntity(dto,category));
       return ProductMapper.toDto(save);
    }

    @Override
    public ProductWithCategoryDto getProductWithCategory(long id)  {
            Product product = repo.findById(id)
                    .orElseThrow(()->new ProductWithCategoryException("This Product Id  =  "+id+" Not found "));
            return ProductMapper.toProductWithCategoryDto(product);
    }


//    @Override
//    public List<CategoryDTO> getAllCategories() throws IOException {
//        return repo.findAll()
//                .stream()
//                .map(category -> CategoryDTO.builder()
//                        .title(category.getTitle())
//                        .price(category.getPrice())
//                        .build()).collect(Collectors.toList());
//    }
}
