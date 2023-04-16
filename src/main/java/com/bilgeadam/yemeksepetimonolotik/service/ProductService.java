package com.bilgeadam.yemeksepetimonolotik.service;

import com.bilgeadam.yemeksepetimonolotik.dto.request.ProductSaveRequestDto;
import com.bilgeadam.yemeksepetimonolotik.mapper.IProductMapper;
import com.bilgeadam.yemeksepetimonolotik.repository.IProductRepository;
import com.bilgeadam.yemeksepetimonolotik.repository.entity.Product;
import com.bilgeadam.yemeksepetimonolotik.utility.ServiceManager;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService extends ServiceManager<Product,Long> {
    private final IProductRepository productRepository;


    public ProductService(IProductRepository productRepository) {
        super(productRepository);
        this.productRepository = productRepository;
    }

    public Product save(ProductSaveRequestDto dto){
        Optional<Product> product= productRepository.findByProductNameIgnoreCase(dto.getProductName());
        if (product.isPresent()){
            throw new RuntimeException("Böyle bir ürün bulunmaktadır !");
        }
       return save(IProductMapper.INSTANCE.ProductSaveRequestDtoToProduct(dto));
    }
}
