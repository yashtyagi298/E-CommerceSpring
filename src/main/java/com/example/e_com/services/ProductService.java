package com.example.e_com.services;

import com.example.e_com.dtos.CategoryDTO;
import com.example.e_com.dtos.OneProductDTO;
import com.example.e_com.dtos.ProductDto;
import com.example.e_com.entity.Category;
import com.example.e_com.entity.Product;
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
    public OneProductDTO getOneProduct(Long id) throws Exception {
        return repo.findById(id)
                .map(ProductMapper::toOneProduct)
                .orElseThrow(()->new Exception("Product not found bro"));
    }

    @Override
    public ProductDto createProduct(ProductDto dto) throws Exception {
        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(()-> new Exception("Invlaid Category "));

       Product save =  repo.save(ProductMapper.toEntity(dto,category));
       return ProductMapper.toDto(save);
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
