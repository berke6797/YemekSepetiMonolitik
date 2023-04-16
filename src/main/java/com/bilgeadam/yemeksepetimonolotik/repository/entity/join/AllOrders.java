package com.bilgeadam.yemeksepetimonolotik.repository.entity.join;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AllOrders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long productId;
    Long orderId;
    Long customerId;
    String customerName;
    String customerSurname;
    String customerAddress;
    String productName;
    String restaurantName;
}
