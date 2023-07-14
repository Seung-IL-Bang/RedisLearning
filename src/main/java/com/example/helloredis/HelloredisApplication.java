package com.example.helloredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class HelloredisApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloredisApplication.class, args);
	}

}
