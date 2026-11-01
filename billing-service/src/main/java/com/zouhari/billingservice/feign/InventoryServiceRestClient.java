package com.zouhari.billingservice.feign;

import com.zouhari.billingservice.model.Product;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


/**
 * @author ZOUHARI Dyae errahmane
 * @Pseudo dezy
 **/

@FeignClient(name = "inventory-service")
public interface InventoryServiceRestClient {
    @GetMapping("/products/{id}")
    @CircuitBreaker(name = "inventory-service", fallbackMethod = "getDefaultProduct")
    Product getProduct(@PathVariable Long id);
    default Product getDefaultProduct(Long id,Exception exception) {

       return Product.builder().id(String.valueOf(id)).build();
    }
}