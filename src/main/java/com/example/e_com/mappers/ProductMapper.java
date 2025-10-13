package com.example.e_com.mappers;

import com.example.e_com.dtos.OneProductDTO;
import com.example.e_com.dtos.ProductDto;
import com.example.e_com.entity.Product;

public class ProductMapper {

    public static ProductDto toDto(Product product){

        return ProductDto.builder()
                .id(product.getId())
                .title(product.getTitle())
                .price(product.getPrice())
                .category(product.getCategory())
                .description(product.getDescription())
                .image(product.getImage())
                .build();

    }

    public static Product toEntity(ProductDto dto){
        return Product.builder()
                .title(dto.getTitle())
                .price(dto.getPrice())
                .category(dto.getCategory())
                .description(dto.getDescription())
                .image(dto.getImage())
                .build();
    }
    // in this method we do not consider Id beacuse it will done by BaseEntity
    public static OneProductDTO toOneProduct(Product product){
        return OneProductDTO.builder()
                .title(product.getTitle())
                .price(product.getPrice())
                .description(product.getDescription())
                .category(product.getCategory())
                .build();
    }
}
