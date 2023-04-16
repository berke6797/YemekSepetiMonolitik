package com.bilgeadam.yemeksepetimonolotik.mapper;

import com.bilgeadam.yemeksepetimonolotik.dto.request.RestaurantSaveRequestDto;
import com.bilgeadam.yemeksepetimonolotik.repository.entity.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")
public interface IRestaurantMapper {
    IRestaurantMapper INSTANCE= Mappers.getMapper(IRestaurantMapper.class);
    Restaurant RestaurantSaveRequestDtoToRestaurant (final RestaurantSaveRequestDto dto);
}
