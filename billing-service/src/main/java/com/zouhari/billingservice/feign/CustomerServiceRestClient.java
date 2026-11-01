package com.zouhari.billingservice.feign;

import com.zouhari.billingservice.model.Customer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
/**
 * @author ZOUHARI Dyae errahmane
 * @Pseudo dezy
 **/

@FeignClient(name = "customer-service")
public interface CustomerServiceRestClient {
    @GetMapping("/customers/{id}")
    @CircuitBreaker(name = "customer-service", fallbackMethod = "getDefaultCustomer")
    Customer getCustomerById(@PathVariable Long id);
    default Customer getDefaultCustomer(Long id , Exception exception) {
        exception.printStackTrace();
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName("NotFound");
        customer.setEmail("NotFound");
        return customer;
    }
}