package com.example.e_com.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

// Instant class from Java Time API > reprensents the timestamp in the UTC format
import java.time.Instant;

// is JPA annotation used to define the base class that contains the common fields
// which will be inhertied and mapped into child entity tables
// Unlike  @Entity > it does not get its own table
// this file just remove duplication when common eneities shares similer atributes like , id , timestamp, createdAt
@MappedSuperclass
//Register BaseEntity and populate all attribute
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter

public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // autoIncrement value
    private long id;

    @CreatedDate
    @Column(nullable = false ,updatable = false)
    private Instant createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private Instant updatedAt;

    // This method is automatically called before the entity is saved first time
    @PrePersist
     public  void  onCreate(){
         Instant now = Instant.now();
         this.createdAt=now;
         this.updatedAt= now;
     }


     @PreUpdate
     public void onUpdate(){
         this.updatedAt = Instant.now();
     }
}
