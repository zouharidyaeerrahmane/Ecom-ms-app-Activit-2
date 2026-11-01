package com.zouhari.billingservice.repository;

import com.zouhari.billingservice.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ZOUHARI Dyae errahmane
 * @Pseudo dezy
 **/

public interface BillRepository  extends JpaRepository<Bill, Long> {
}