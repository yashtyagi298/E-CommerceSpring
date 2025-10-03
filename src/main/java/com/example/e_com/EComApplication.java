package com.example.e_com;


import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EComApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.configure().load(); // load env var from .env file
		dotenv.entries().forEach(entry-> System.setProperty(entry.getKey(),entry.getValue())); // set system properties from env var and set them
		SpringApplication.run(EComApplication.class, args);
	}

}
