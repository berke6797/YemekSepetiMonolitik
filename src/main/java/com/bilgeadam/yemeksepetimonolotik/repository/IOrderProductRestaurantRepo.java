package com.bilgeadam.yemeksepetimonolotik.repository;

import com.bilgeadam.yemeksepetimonolotik.repository.entity.join.OrderCustomer;
import com.bilgeadam.yemeksepetimonolotik.repository.entity.join.OrderProductRestaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrderProductRestaurantRepo extends JpaRepository<OrderProductRestaurant,Long> {

    @Query(nativeQuery = true, value =
            "select p.product_id, o.order_id,r.restaurant_id,c.customer_name,c.customer_surname,c.customer_address,p.product_name,r.restaurant_name from tbl_order as o \n" +
                    "inner join order_product_id as op on op.order_order_id\n" +
                    "inner join tbl_product as p on p.product_id=op.product_id\n" +
                    "inner join tbl_customer as c on c.customer_id=o.customer_id\n" +
                    "inner join tbl_restaurant as r on r.restaurant_id=p.restaurant_id\n" +
                    "where r.restaurant_id=?1")
    List<OrderProductRestaurant> restorantVerilenSiparisler(Long restaurantId);


}
