package com.example.e_com.services;

import com.example.e_com.dtos.CategoryDTO;
import com.example.e_com.dtos.OneProductDTO;
import com.example.e_com.dtos.ProductDto;
import com.example.e_com.entity.Product;
import com.example.e_com.mappers.ProductMapper;
import com.example.e_com.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service("ProductService")
public class ProductService implements IOneProductService ,ICategoryService{
    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }


    @Override
    public OneProductDTO getOneProduct(Long id) throws Exception {
        return repo.findById(id)
                .map(ProductMapper::toOneProduct)
                .orElseThrow(()->new Exception("Product not found bro"));
    }

    @Override
    public ProductDto createProduct(ProductDto dto) {
       Product save =  repo.save(ProductMapper.toEntity(dto));
       return ProductMapper.toDto(save);
    }



    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        return repo.findAll()
                .stream()
                .map(category -> CategoryDTO.builder()
                        .title(category.getTitle())
                        .price(category.getPrice())
                        .build()).collect(Collectors.toList());
    }
}
