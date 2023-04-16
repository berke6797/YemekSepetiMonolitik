package com.bilgeadam.yemeksepetimonolotik.mapper;

import com.bilgeadam.yemeksepetimonolotik.dto.request.ProductSaveRequestDto;
import com.bilgeadam.yemeksepetimonolotik.repository.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")

public interface IProductMapper {
    IProductMapper INSTANCE = Mappers.getMapper(IProductMapper.class);
    Product ProductSaveRequestDtoToProduct(final ProductSaveRequestDto dto);

}
