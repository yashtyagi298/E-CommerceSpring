package com.example.e_com.gateway;

import com.example.e_com.dtos.CategoryDTO;
import com.example.e_com.dtos.ProductDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Component
@Qualifier("FakeStoreRestTemplate")
public class FakeStoreRestTemplate implements ICategoryGateway{
    private final RestTemplate restTemplate;
    @Value("${FAKE_STORE_BASE_URL_WITH_PATH}")
    private String baseUrl;
    public FakeStoreRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {

        ResponseEntity<CategoryDTO[]> response = restTemplate.getForEntity(baseUrl, CategoryDTO[].class);
        if (response.getBody() == null) {
            throw new IOException("Failed to fetch categories");
        }

        return Arrays.asList(response.getBody());

    }
}
