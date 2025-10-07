package com.example.e_com.services;

import com.example.e_com.dtos.CategoryDTO;
import com.example.e_com.gateway.FakeStoreRestTemplate;
import com.example.e_com.gateway.ICategoryGateway;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class RestTemplateFakeStore implements ICategoryGateway {
    private final FakeStoreRestTemplate fakeStoreRestTemplate;

    public RestTemplateFakeStore(@Qualifier("FakeStoreRestTemplate") FakeStoreRestTemplate _fakeStoreRestTemplate) {
        this.fakeStoreRestTemplate = _fakeStoreRestTemplate;
    }

    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        return fakeStoreRestTemplate.getAllCategories();
    }
}
