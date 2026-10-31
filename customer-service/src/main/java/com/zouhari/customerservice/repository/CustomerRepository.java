package com.zouhari.customerservice.repository;


import com.zouhari.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author ZOUHARI Dyae errahmane
 * @Pseudo dezy
 **/

@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
