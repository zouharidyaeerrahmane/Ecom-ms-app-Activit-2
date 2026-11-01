package com.zouhari.billingservice.model;

import lombok.*;

/**
 * @author ZOUHARI Dyae errahmane
 * @Pseudo dezy
 **/


@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Product {
    private String id;
    private String name;
    private double price;
    private int quantity;
}
