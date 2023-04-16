package com.bilgeadam.yemeksepetimonolotik.controller;

import com.bilgeadam.yemeksepetimonolotik.dto.request.RestaurantSaveRequestDto;
import com.bilgeadam.yemeksepetimonolotik.repository.entity.Restaurant;
import com.bilgeadam.yemeksepetimonolotik.repository.entity.join.OrderProductRestaurant;
import com.bilgeadam.yemeksepetimonolotik.repository.entity.join.ProductRestaurant;
import com.bilgeadam.yemeksepetimonolotik.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static com.bilgeadam.yemeksepetimonolotik.constants.EndPoints.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(RESTAURANT)
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;
    @PostMapping(SAVE)
    public ResponseEntity<Restaurant> save(@RequestBody @Valid RestaurantSaveRequestDto dto){
        return ResponseEntity.ok(restaurantService.save(dto));
    }
    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Restaurant>> findAll(){
        return ResponseEntity.ok(restaurantService.findAll());
    }


    @PostMapping(FIND_ALL_ORDER_RESTAURANT_ID)
    public List<OrderProductRestaurant> restorantVerilenSiparisler(@RequestBody Long restaurantId){
        return restaurantService.restorantVerilenSiparisler(restaurantId);
    }
    @GetMapping(FIND_ALL_PRODUCT_WITH_RESTAURANT_ID)
    public List<ProductRestaurant> restorandakiProductlariListele(Long restaurantId){
        return restaurantService.restorandakiProductlariListele(restaurantId);
    }
}
