package com.bilgeadam.yemeksepetimonolotik.service;

import com.bilgeadam.yemeksepetimonolotik.repository.IOrderProductRestaurantRepo;
import com.bilgeadam.yemeksepetimonolotik.repository.entity.join.OrderProductRestaurant;
import com.bilgeadam.yemeksepetimonolotik.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderProductRestaurantService extends ServiceManager<OrderProductRestaurant,Long> {
    private final IOrderProductRestaurantRepo orderProductRestaurantRepo;

    public OrderProductRestaurantService(IOrderProductRestaurantRepo orderProductRestaurantRepo) {
        super(orderProductRestaurantRepo);
        this.orderProductRestaurantRepo = orderProductRestaurantRepo;
    }

    public List<OrderProductRestaurant> restorantVerilenSiparisler(Long restaurantId){
      return  orderProductRestaurantRepo.restorantVerilenSiparisler(restaurantId);
    }
}
