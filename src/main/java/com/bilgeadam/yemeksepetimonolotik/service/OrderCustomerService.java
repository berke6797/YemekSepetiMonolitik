package com.bilgeadam.yemeksepetimonolotik.service;

import com.bilgeadam.yemeksepetimonolotik.repository.IOrderCustomerRepo;
import com.bilgeadam.yemeksepetimonolotik.repository.IProductRepository;
import com.bilgeadam.yemeksepetimonolotik.repository.IRestaurantRepository;
import com.bilgeadam.yemeksepetimonolotik.repository.entity.join.OrderCustomer;
import com.bilgeadam.yemeksepetimonolotik.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderCustomerService extends ServiceManager<OrderCustomer,Long> {
    private final IOrderCustomerRepo orderCustomerRepo;


    public OrderCustomerService(IOrderCustomerRepo orderCustomerRepo) {
        super(orderCustomerRepo);
        this.orderCustomerRepo = orderCustomerRepo;
    }

   public List<OrderCustomer> musteriyeOzelSiparisleriListele(Long customerId){
        return orderCustomerRepo.musteriyeOzelSiparisleriListele(customerId);
   }


}
