package com.example.e_com.gateway.Api;

import com.example.e_com.dtos.ProductDto;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FakeStoreProductApi {
    @GET("products/{id}")
    Call<ProductDto> getProductById(@Path("id")Long id);
}
