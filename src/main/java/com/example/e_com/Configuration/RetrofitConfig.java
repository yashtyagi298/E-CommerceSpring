package com.example.e_com.Configuration;

import com.example.e_com.gateway.Api.FakeStoreApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class RetrofitConfig {

    @Value("${BASE_URL}")
  private String baseUrl;
    @Bean
    public Retrofit retrofit(){
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    @Bean
    public FakeStoreApi fakeStoreCategoryApi(Retrofit retrofit){
           return retrofit.create(FakeStoreApi.class);
    }
}
