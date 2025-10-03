package com.example.e_com.gateway.Api;


import com.example.e_com.dtos.ProductDto;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.http.GET;

import java.io.IOException;
import java.util.List;

@Component
public interface FakeStoreApi {

    @GET("products")
    Call<List<ProductDto>> getAllFakeCategories() throws IOException;
}
