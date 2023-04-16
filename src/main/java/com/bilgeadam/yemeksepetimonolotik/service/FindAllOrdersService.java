package com.bilgeadam.yemeksepetimonolotik.service;

import com.bilgeadam.yemeksepetimonolotik.repository.IFindAllOrdersRepo;
import com.bilgeadam.yemeksepetimonolotik.repository.entity.join.AllOrders;
import com.bilgeadam.yemeksepetimonolotik.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllOrdersService extends ServiceManager<AllOrders,Long> {
    private final IFindAllOrdersRepo findAllOrderRepo;

    public FindAllOrdersService(IFindAllOrdersRepo findAllOrderRepo) {
        super(findAllOrderRepo);
        this.findAllOrderRepo = findAllOrderRepo;
    }

    public List<AllOrders> tumSiparisleriListele(){
        return findAllOrderRepo.tumSiparisleriListele();
    }

}
