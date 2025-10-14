package com.example.e_com.dtos;

import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {
    private long id;
    private String name;
    private double price;
    private String description;
    private long categoryId;
    private String image;


}
