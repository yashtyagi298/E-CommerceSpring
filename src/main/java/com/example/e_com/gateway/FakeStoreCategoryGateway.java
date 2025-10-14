package com.example.e_com.gateway;

import com.example.e_com.dtos.CategoryDTO;
import com.example.e_com.dtos.ProductDto;
import com.example.e_com.gateway.Api.FakeStoreApi;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Primary
public class FakeStoreCategoryGateway implements ICategoryGateway {
      private final FakeStoreApi fakestoreapi;

      FakeStoreCategoryGateway(FakeStoreApi _fakestoreapi){
          this.fakestoreapi = _fakestoreapi;
      }
    @Override
    public List<CategoryDTO> getAllCategories() throws IOException{
        List<ProductDto> products =  this.fakestoreapi.getAllFakeCategories().execute().body();
        if(products == null){
            throw new IOException("Failed to fetch the details from retrofit api");
        }
        return products.stream()
                .map(product -> CategoryDTO.builder()
                        .name(product.getName())
                        .id(product.getId())
                        .build())
                .collect(Collectors.toList());
    }
}
