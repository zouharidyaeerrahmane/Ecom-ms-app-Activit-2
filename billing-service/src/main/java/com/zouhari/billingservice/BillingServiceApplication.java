package com.zouhari.billingservice;

import com.zouhari.billingservice.entities.Bill;
import com.zouhari.billingservice.entities.ProductItem;
import com.zouhari.billingservice.repository.BillRepository;
import com.zouhari.billingservice.repository.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.*;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(BillRepository billRepository,
                                        ProductItemRepository productItemRepository){

        return args -> {
            List<Long> customerIds = List.of(1L,2L,3L);
            List<Long> productIds = List.of(1L,2L,3L);
            customerIds.forEach(clientId -> {
                Bill bill = new Bill();
                bill.setBillingDate(new Date());
                bill.setCustomerId(clientId);
                billRepository.save(bill);
                productIds.forEach(productId -> {
                    ProductItem productItem = new ProductItem();
                    productItem.setPrice(1000/Math.random()*2);
                    productItem.setQuantity(1 + new Random().nextInt(20));
                    productItem.setProductId(productId);
                    productItem.setBill(bill);
                    productItemRepository.save(productItem);
                });


            });


        };
    }

}
