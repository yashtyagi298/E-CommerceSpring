package com.example.e_com.gateway;

import com.example.e_com.dtos.OneProductDTO;
import com.example.e_com.dtos.ProductDto;
import com.example.e_com.gateway.Api.FakeStoreProductApi;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class FakeStoreProductGateway implements IGetProduct {
    private final FakeStoreProductApi productApi;
    FakeStoreProductGateway(FakeStoreProductApi _productApi){
        this.productApi= _productApi;
    }

    @Override
    public OneProductDTO getProductById(Long id) throws IOException {
       ProductDto product = this.productApi.getProductById(id).execute().body();
       if(product==null){
           throw new IOException("Product can not be fetch by retrofit");
       }
      return  OneProductDTO.builder()
              .title(product.getTitle())
              .price(product.getPrice())
              .description(product.getDescription())
              .category(product.getCategory())
              .build();
    }
}
