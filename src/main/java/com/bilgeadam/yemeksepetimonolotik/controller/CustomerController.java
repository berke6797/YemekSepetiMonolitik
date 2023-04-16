package com.bilgeadam.yemeksepetimonolotik.controller;

import com.bilgeadam.yemeksepetimonolotik.dto.request.ActivateRequestDto;
import com.bilgeadam.yemeksepetimonolotik.dto.request.CustomerRegisterRequestDto;
import com.bilgeadam.yemeksepetimonolotik.dto.request.LoginRequestDto;
import com.bilgeadam.yemeksepetimonolotik.dto.response.CustomerRegisterResponseDto;
import com.bilgeadam.yemeksepetimonolotik.repository.entity.Customer;
import com.bilgeadam.yemeksepetimonolotik.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static com.bilgeadam.yemeksepetimonolotik.constants.EndPoints.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(CUSTOMER)
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping(REGISTER)
    ResponseEntity<CustomerRegisterResponseDto> register(@RequestBody @Valid CustomerRegisterRequestDto dto){
        return ResponseEntity.ok(customerService.register(dto));
    }
    @GetMapping(FIND_ALL)
    ResponseEntity<List<Customer>> findAll(){
        return ResponseEntity.ok(customerService.findAll());
    }

    @PostMapping(LOGIN)
    ResponseEntity<Boolean> login(@RequestBody LoginRequestDto dto){
        return ResponseEntity.ok(customerService.login(dto));
    }
    @PostMapping(ACTIVATE_STATUS)
    ResponseEntity<Boolean> activateStatus (@RequestBody ActivateRequestDto dto){
        return ResponseEntity.ok(customerService.activateStatus(dto));
    }
    @GetMapping(FIND_ALL_REGISTERED_CUSTOMER)
    ResponseEntity<List<Customer>> findAllCustomerRegistered(){
        return ResponseEntity.ok(customerService.findAllCustomerRegistered());
    }

}
