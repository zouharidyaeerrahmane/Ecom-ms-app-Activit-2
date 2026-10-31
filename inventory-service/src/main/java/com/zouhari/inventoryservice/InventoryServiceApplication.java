package com.zouhari.inventoryservice;

import com.zouhari.inventoryservice.entities.Product;
import com.zouhari.inventoryservice.repository.ProductRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository){
        return args -> {
            productRepository.save(Product.builder()
                    .name("Computer")
                    .price(3200)
                    .quantity(11)
                    .build());
            productRepository.save(Product.builder()
                    .name("Printer")
                    .price(1299)
                    .quantity(10)
                    .build());
            productRepository.save(Product.builder()
                    .name("Smart Phone")
                    .price(5400)
                    .quantity(8)
                    .build());

        };
    }

}