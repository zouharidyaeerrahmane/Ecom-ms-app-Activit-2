package com.zouhari.customerservice;

import com.zouhari.customerservice.entities.Customer;
import com.zouhari.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository ){
        return args -> {
            customerRepository.save(Customer.builder()
                    .name("dezy").email("dezy@gmail.com")
                    .build());
            customerRepository.save(Customer.builder()
                    .name("amine").email("amine@gmail.com")
                    .build());
            customerRepository.save(Customer.builder()
                    .name("ahmed").email("ahmed@gmail.com")
                    .build());

        };
    }

}