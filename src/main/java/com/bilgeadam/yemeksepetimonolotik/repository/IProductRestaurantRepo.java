package com.bilgeadam.yemeksepetimonolotik.repository;

import com.bilgeadam.yemeksepetimonolotik.repository.entity.join.ProductRestaurant;
import lombok.extern.java.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRestaurantRepo extends JpaRepository<ProductRestaurant, Long> {
    @Query(nativeQuery = true, value = "select p.product_name,p.cost,r.restaurant_id,r.restaurant_name from tbl_product as p \n" +
            "inner join tbl_restaurant as r on p.restaurant_id=r.restaurant_id \n" +
            "where r.restaurant_id=?1")
    public List<ProductRestaurant> restorandakiProductlariListele(Long restaurantId);
}
