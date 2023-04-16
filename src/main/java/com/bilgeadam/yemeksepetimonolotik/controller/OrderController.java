package com.bilgeadam.yemeksepetimonolotik.controller;

import com.bilgeadam.yemeksepetimonolotik.repository.entity.Order;
import com.bilgeadam.yemeksepetimonolotik.repository.entity.join.OrderCustomer;
import com.bilgeadam.yemeksepetimonolotik.repository.entity.join.AllOrders;
import com.bilgeadam.yemeksepetimonolotik.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static com.bilgeadam.yemeksepetimonolotik.constants.EndPoints.*;
import java.util.List;

@RestController
@RequestMapping(ORDER)
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping(SAVE)
    public ResponseEntity<Order> save(@RequestBody Order order) {
        return ResponseEntity.ok(orderService.save(order));
    }

    @GetMapping(FIND_ALL_BY_CUSTOMER_ID +"/{customerId}")
    public ResponseEntity<List<OrderCustomer>> musteriyeOzelSiparisleriListele(@PathVariable Long customerId) {
        return ResponseEntity.ok(orderService.musteriyeOzelSiparisleriListele(customerId));
    }

    @GetMapping(FIND_ALL_ORDERS)
    public ResponseEntity<List<AllOrders>> tumSiparisleriListele() {
        return ResponseEntity.ok(orderService.tumSiparisleriListele());
    }
}
