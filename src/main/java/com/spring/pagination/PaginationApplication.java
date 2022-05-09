package com.spring.pagination;

import com.spring.pagination.model.Product;
import com.spring.pagination.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class PaginationApplication {

	@Autowired
	ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(PaginationApplication.class, args);
	}

	@Bean
	public CommandLineRunner run() {
		return args -> {
			System.out.println("Data creation started...");
			productRepository.save(new Product("Whole Wheat Biscuit", "Whole Wheat Biscuit", 5, "snacks"));
			productRepository.save(new Product("Kodo Millet", "XYZ Kodo Millet healthy", 2, "millets"));
			productRepository.save(new Product("Dried Red Chilli", "Dried Whole Red Chilli", 2, "spices"));
			productRepository.save(new Product("Pearl Millet", "Healthy Pearl Millet", 1, "millets"));
			productRepository.save(new Product("Cheese Crackers", "Bonny Cheese Crackers Plain", 6, "snacks"));
			System.out.println("Data creation complete...");
		};
	}

}
