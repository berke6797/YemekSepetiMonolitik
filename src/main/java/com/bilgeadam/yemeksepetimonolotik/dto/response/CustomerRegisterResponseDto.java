package com.bilgeadam.yemeksepetimonolotik.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRegisterResponseDto {
     Long customerId;
     String email;
     String activationCode;
}
