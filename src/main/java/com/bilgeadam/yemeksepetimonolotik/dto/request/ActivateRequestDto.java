package com.bilgeadam.yemeksepetimonolotik.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActivateRequestDto {
    Long customerId;
    String activationCode;
}
