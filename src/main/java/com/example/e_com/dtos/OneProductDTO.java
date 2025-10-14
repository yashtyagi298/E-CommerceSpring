package com.example.e_com.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class OneProductDTO {

    private String title;
    private double price;
    private String description;
    private long categoryId;


}
