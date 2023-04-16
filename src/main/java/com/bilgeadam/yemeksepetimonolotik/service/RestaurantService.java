package com.bilgeadam.yemeksepetimonolotik.service;

import com.bilgeadam.yemeksepetimonolotik.dto.request.RestaurantSaveRequestDto;
import com.bilgeadam.yemeksepetimonolotik.mapper.IRestaurantMapper;
import com.bilgeadam.yemeksepetimonolotik.repository.IRestaurantRepository;
import com.bilgeadam.yemeksepetimonolotik.repository.entity.Restaurant;
import com.bilgeadam.yemeksepetimonolotik.repository.entity.join.OrderProductRestaurant;
import com.bilgeadam.yemeksepetimonolotik.repository.entity.join.ProductRestaurant;
import com.bilgeadam.yemeksepetimonolotik.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService extends ServiceManager<Restaurant,Long> {
    private final IRestaurantRepository restaurantRepository;
    private final OrderProductRestaurantService orderProductRestaurantService;
    private final ProductRestaurantService productRestaurantService;

    public RestaurantService(IRestaurantRepository restaurantRepository, OrderProductRestaurantService orderProductRestaurantService, ProductRestaurantService productRestaurantService) {
        super(restaurantRepository);
        this.restaurantRepository = restaurantRepository;
        this.orderProductRestaurantService = orderProductRestaurantService;
        this.productRestaurantService = productRestaurantService;
    }

    public Restaurant save(RestaurantSaveRequestDto dto){
      Optional<Restaurant> optionalRestaurant = restaurantRepository.findByRestaurantNameAndRestaurantAddressIgnoreCase(dto.getRestaurantName(),dto.getRestaurantAddress());
      if(optionalRestaurant.isEmpty()){
        return save(IRestaurantMapper.INSTANCE.RestaurantSaveRequestDtoToRestaurant(dto));
      }else
        throw new RuntimeException("Böyle bir restaurant kayıtlıdır. Başka bir adres ve isimle yeniden deneyiniz.");

    }
    public List<OrderProductRestaurant> restorantVerilenSiparisler(Long restaurantId){
        return orderProductRestaurantService.restorantVerilenSiparisler(restaurantId);
    }
    public List<ProductRestaurant> restorandakiProductlariListele(Long restaurantId){
        return productRestaurantService.restorandakiProductlariListele(restaurantId);
    }

}
