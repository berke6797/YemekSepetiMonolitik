package com.bilgeadam.yemeksepetimonolotik.service;

import com.bilgeadam.yemeksepetimonolotik.repository.IOrderRepository;
import com.bilgeadam.yemeksepetimonolotik.repository.entity.Order;
import com.bilgeadam.yemeksepetimonolotik.repository.entity.join.OrderCustomer;
import com.bilgeadam.yemeksepetimonolotik.repository.entity.join.AllOrders;
import com.bilgeadam.yemeksepetimonolotik.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService extends ServiceManager<Order,Long> {
    private final IOrderRepository orderRepository;
    private final OrderCustomerService orderCustomerService;
    private final FindAllOrdersService findAllOrdersService;

    public OrderService(IOrderRepository orderRepository, OrderCustomerService orderCustomerService, FindAllOrdersService findAllOrdersService) {
        super(orderRepository);
        this.orderRepository = orderRepository;
        this.orderCustomerService = orderCustomerService;
        this.findAllOrdersService = findAllOrdersService;
    }
    public Order save (Order order){
        Optional<Order> orderOptional=orderRepository.findById(order.getOrderId());
        if(orderOptional.isPresent()){
            throw new RuntimeException("Bu id ile sadece bir kez sipariş verebilirsiniz !");
        }
        return orderRepository.save(order);
    }

    public List<OrderCustomer> musteriyeOzelSiparisleriListele(Long customerId){
        return orderCustomerService.musteriyeOzelSiparisleriListele(customerId);
    }

    public List<AllOrders> tumSiparisleriListele(){
        return findAllOrdersService.tumSiparisleriListele();
    }






}
