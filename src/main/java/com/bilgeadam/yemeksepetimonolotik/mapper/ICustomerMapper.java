package com.bilgeadam.yemeksepetimonolotik.mapper;

import com.bilgeadam.yemeksepetimonolotik.dto.request.CustomerRegisterRequestDto;
import com.bilgeadam.yemeksepetimonolotik.dto.response.CustomerRegisterResponseDto;
import com.bilgeadam.yemeksepetimonolotik.repository.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")
public interface ICustomerMapper {
    ICustomerMapper INSTANCE = Mappers.getMapper(ICustomerMapper.class);
    Customer customerRegisterRequestDtoToCustomer (final CustomerRegisterRequestDto dto);
    CustomerRegisterResponseDto customerToRegisterResponseDto (final Customer customer);

}
