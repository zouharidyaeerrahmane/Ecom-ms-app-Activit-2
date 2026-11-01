package com.zouhari.billingservice.entities;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.zouhari.billingservice.model.Product;
import jakarta.persistence.*;
import lombok.*;


/**
 * @author ZOUHARI Dyae errahmane
 * @Pseudo dezy
 **/

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class ProductItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productId;
    private int quantity;
    private double price;
    @ManyToOne
    private Bill bill;
    @Transient
    private Product product;


}
