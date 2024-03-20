package com.productentity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductEntityApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductEntityApplication.class, args);

//		Product product =null;
//		Optional.of(product).map(p -> {
//			System.out.println("inside map");
//			return p;
//		}).orElseThrow(() -> new RuntimeException());
	}

}
