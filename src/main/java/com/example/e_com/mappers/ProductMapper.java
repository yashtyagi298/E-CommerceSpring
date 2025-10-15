package com.example.e_com.mappers;

import com.example.e_com.dtos.OneProductDTO;
import com.example.e_com.dtos.ProductDto;
import com.example.e_com.dtos.ProductWithCategoryDto;
import com.example.e_com.entity.Category;
import com.example.e_com.entity.Product;

public class ProductMapper {

    public static ProductDto toDto(Product product){

        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .categoryId(product.getId())
                .description(product.getDescription())
                .image(product.getImage())
                .build();

    }

    public static Product toEntity(ProductDto dto, Category category){
        return Product.builder()
                .name(dto.getName())
                .price(dto.getPrice())
                .category(category)
                .description(dto.getDescription())
                .image(dto.getImage())
                .build();
    }
    // in this method we do not consider Id beacuse it will done by BaseEntity
    public static OneProductDTO toOneProduct(Product product){
        return OneProductDTO.builder()
                .title(product.getName())
                .price(product.getPrice())
                .description(product.getDescription())
                .categoryId(product.getCategory().getId())
                .build();
    }

    public static ProductWithCategoryDto toProductWithCategoryDto (Product product){
        return ProductWithCategoryDto.builder()
                .name(product.getName())
                .price(product.getPrice())
                .description(product.getDescription())
                .image(product.getImage())
                .category(CategoryMapper.toDto(product.getCategory()))
                .build();
    }
}
