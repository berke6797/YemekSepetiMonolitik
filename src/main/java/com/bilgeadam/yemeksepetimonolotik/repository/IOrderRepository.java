package com.bilgeadam.yemeksepetimonolotik.repository;

import com.bilgeadam.yemeksepetimonolotik.repository.entity.Order;
import com.bilgeadam.yemeksepetimonolotik.repository.entity.join.OrderCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrderRepository extends JpaRepository<Order,Long> {


}
