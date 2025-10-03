package com.example.e_com.dtos;

import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {
    private int id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;


}
