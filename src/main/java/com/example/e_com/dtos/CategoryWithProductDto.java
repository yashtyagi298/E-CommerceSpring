package com.example.e_com.dtos;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryWithProductDto {
    private long id;
    private String name;

    private List<ProductDto> products;
}
