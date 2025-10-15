package com.example.e_com.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category extends BaseEntity{

    @Column(nullable = false , unique = true)
    private String name;

    @OneToMany(mappedBy = "category" ,fetch = FetchType.LAZY)
    private List<Product> products;
}
