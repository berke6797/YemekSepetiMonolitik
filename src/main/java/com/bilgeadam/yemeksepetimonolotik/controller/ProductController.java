package com.bilgeadam.yemeksepetimonolotik.controller;

import com.bilgeadam.yemeksepetimonolotik.dto.request.ProductSaveRequestDto;
import com.bilgeadam.yemeksepetimonolotik.repository.entity.Product;
import com.bilgeadam.yemeksepetimonolotik.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.bilgeadam.yemeksepetimonolotik.constants.EndPoints.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(PRODUCT)
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @PostMapping(SAVE)
    public ResponseEntity<Product> save (@RequestBody @Valid ProductSaveRequestDto dto){
        return ResponseEntity.ok(productService.save(dto));
    }
}
