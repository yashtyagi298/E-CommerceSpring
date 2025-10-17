package com.example.e_com.exception;

public class ProductNotFoundException extends RuntimeException{

    public ProductNotFoundException (String message){
        super(message);
    }
}
