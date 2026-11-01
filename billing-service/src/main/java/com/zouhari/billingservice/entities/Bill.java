package com.zouhari.billingservice.entities;

import com.zouhari.billingservice.model.Customer;
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.List;

/**
 * @author ZOUHARI Dyae errahmane
 * @Pseudo dezy
 **/


@Entity
@NoArgsConstructor @AllArgsConstructor @Getter @Setter @Builder
public class Bill {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date billingDate;
    private long customerId;
    @OneToMany(mappedBy = "bill")
    private List<ProductItem> productItems;
    @Transient
    private Customer customer;

}