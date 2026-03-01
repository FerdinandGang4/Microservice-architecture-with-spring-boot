package com.example.ProductServicev1;

import com.example.ProductServicev1.Model.Product;
import com.example.ProductServicev1.Repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProductServicev1Application {

	public static void main(String[] args) {
		SpringApplication.run(ProductServicev1Application.class, args);
	}

	@Bean
	CommandLineRunner run(ProductRepository productRepository) {
		return args -> {
			Product product = new Product(
					"P1001",
					"Laptop",
					10
			);

			productRepository.save(product);
			System.out.println("✅ Product saved to MongoDB");
		};
	}
}