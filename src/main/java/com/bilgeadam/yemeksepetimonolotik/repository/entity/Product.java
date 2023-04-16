package com.bilgeadam.yemeksepetimonolotik.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long productId;
    @NotBlank(message = "Product name boş bırakılamaz !")
    String productName;
    String category;
    @NotNull(message = "Ürünün fiyatı boş bırakılmaz !")
    double cost;
    @Column(name = "restaurantId")
    Long restaurantId;
}
