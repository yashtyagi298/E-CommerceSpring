package com.example.e_com.entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product extends BaseEntity {
//    private long id;
    private String name;
    private double price;
    private String description;
    private String image;

    @ManyToOne
    @JoinColumn(name="categoryId" , nullable = false)
    private Category category;
}
