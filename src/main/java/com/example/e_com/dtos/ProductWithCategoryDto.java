package com.example.e_com.dtos;

import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductWithCategoryDto {
    private long id;
    private String name;
    private double price;
    private String description;
    private long categoryId;
    private String image;

    private CategoryDTO category;

}
