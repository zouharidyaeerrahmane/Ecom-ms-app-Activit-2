package com.zouhari.inventoryservice.repository;

import com.zouhari.inventoryservice.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author ZOUHARI Dyae errahmane
 * @Pseudo dezy
 **/

@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product,Long> {
}
