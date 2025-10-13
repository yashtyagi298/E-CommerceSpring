package com.example.e_com.entity;


import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product extends BaseEntity {
    private long id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;
}
