package com.zouhari.billingservice.repository;

import com.zouhari.billingservice.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

/**
 * @author ZOUHARI Dyae errahmane
 * @Pseudo dezy
 **/
@RepositoryRestResource
public interface BillRepository  extends JpaRepository<Bill, Long> {
}