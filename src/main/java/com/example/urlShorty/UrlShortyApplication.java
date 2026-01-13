package com.example.urlShorty;

import com.example.urlShorty.service.KeyGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.security.Key;

@SpringBootApplication
public class UrlShortyApplication {

	public static void main(String[] args) {

		SpringApplication.run(UrlShortyApplication.class, args);

	}

}
