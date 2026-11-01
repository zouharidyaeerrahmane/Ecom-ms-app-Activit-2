package com.zouhari.billingservice.repository;

import com.zouhari.billingservice.entities.ProductItem;
import com.zouhari.billingservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author ZOUHARI Dyae errahmane
 * @Pseudo dezy
 **/


public interface ProductItemRepository extends JpaRepository<ProductItem, Long> {
    List<ProductItem> findByBillId(Long BillId);
}