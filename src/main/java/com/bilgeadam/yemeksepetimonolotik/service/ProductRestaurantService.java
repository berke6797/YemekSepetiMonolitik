package com.bilgeadam.yemeksepetimonolotik.service;

import com.bilgeadam.yemeksepetimonolotik.repository.IProductRestaurantRepo;
import com.bilgeadam.yemeksepetimonolotik.repository.entity.join.ProductRestaurant;
import com.bilgeadam.yemeksepetimonolotik.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductRestaurantService extends ServiceManager<ProductRestaurant, Long> {
    private final IProductRestaurantRepo productRestaurantRepo;

    public ProductRestaurantService(IProductRestaurantRepo productRestaurantRepo) {
        super(productRestaurantRepo);
        this.productRestaurantRepo = productRestaurantRepo;
    }

    public List<ProductRestaurant> restorandakiProductlariListele(Long restaurantId) {
        return productRestaurantRepo.restorandakiProductlariListele(restaurantId);
    }


}
