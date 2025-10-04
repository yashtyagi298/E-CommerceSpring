package com.example.e_com.services;

import com.example.e_com.dtos.CategoryDTO;
import com.example.e_com.dtos.OneProductDTO;
import com.example.e_com.gateway.Api.FakeStoreProductApi;
import com.example.e_com.gateway.FakeStoreProductGateway;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class OneProductServiceFakeStore implements IOneProductService{
     FakeStoreProductGateway fakeStoreProductGateway;

     OneProductServiceFakeStore(FakeStoreProductGateway _fakeStoreProductGateway){
         this.fakeStoreProductGateway = _fakeStoreProductGateway;
     }
    @Override
    public OneProductDTO getOneProduct(Long id) throws IOException {
        return fakeStoreProductGateway.getProductById(id);
    }
}
