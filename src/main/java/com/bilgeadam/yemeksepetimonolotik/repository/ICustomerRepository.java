package com.bilgeadam.yemeksepetimonolotik.repository;

import com.bilgeadam.yemeksepetimonolotik.repository.entity.Customer;
import com.bilgeadam.yemeksepetimonolotik.utility.EStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Long> {
    Optional<Customer> findByCustomerId(Long id);
    Optional<Customer> findByEmailIgnoreCase(String email);
    Optional<Customer> findByEmailAndPassword(String email,String password);
    List<Customer> findAllByUserStatusEquals(EStatus status);
}
