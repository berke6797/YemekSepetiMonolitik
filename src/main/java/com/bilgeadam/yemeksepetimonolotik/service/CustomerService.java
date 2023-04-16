package com.bilgeadam.yemeksepetimonolotik.service;

import com.bilgeadam.yemeksepetimonolotik.dto.request.ActivateRequestDto;
import com.bilgeadam.yemeksepetimonolotik.dto.request.CustomerRegisterRequestDto;
import com.bilgeadam.yemeksepetimonolotik.dto.request.LoginRequestDto;
import com.bilgeadam.yemeksepetimonolotik.dto.response.CustomerRegisterResponseDto;
import com.bilgeadam.yemeksepetimonolotik.mapper.ICustomerMapper;
import com.bilgeadam.yemeksepetimonolotik.repository.ICustomerRepository;
import com.bilgeadam.yemeksepetimonolotik.repository.entity.Customer;
import com.bilgeadam.yemeksepetimonolotik.utility.CodeGenerator;
import com.bilgeadam.yemeksepetimonolotik.utility.EStatus;
import com.bilgeadam.yemeksepetimonolotik.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService extends ServiceManager<Customer, Long> {
    private final ICustomerRepository customerRepository;

    public CustomerService(ICustomerRepository customerRepository) {
        super(customerRepository);
        this.customerRepository = customerRepository;
    }

    public CustomerRegisterResponseDto register(CustomerRegisterRequestDto registerDto) {
        Customer customer = ICustomerMapper.INSTANCE.customerRegisterRequestDtoToCustomer(registerDto);
        if (customerRepository.findByEmailIgnoreCase(registerDto.getEmail()).isPresent()) {
            throw new RuntimeException("Bu emaile ait bir kullanıcı bulunmaktadır.");
        } else if (!registerDto.getRepassword().equals(registerDto.getPassword())) {
            throw new RuntimeException("Şifreler birbirleriyle uyuşmamaktadır");
        }
        customer.setActivationCode(CodeGenerator.generateCode());
        customerRepository.save(customer);
        CustomerRegisterResponseDto customerRegisterResponseDto = ICustomerMapper.INSTANCE.customerToRegisterResponseDto(customer);
        return customerRegisterResponseDto;
    }

    public Boolean activateStatus(ActivateRequestDto dto) {
        Optional<Customer> customer = customerRepository.findByCustomerId(dto.getCustomerId());
        if (customer.isEmpty()) {
            throw new RuntimeException("Böyle bir kullanıcı bulunmamaktadır");
        }
        if (!customer.get().getActivationCode().equals(dto.getActivationCode())) {
            throw new RuntimeException("Aktivasyon kodu hatası");
        }
        customer.get().setUserStatus(EStatus.ACTIVE);
        update(customer.get());
        return true;

    }

    public Boolean login(LoginRequestDto dto) {
        Optional<Customer> customer = customerRepository.findByEmailAndPassword(dto.getEmail(), dto.getPassword());
        if (customer.isEmpty()) {
            throw new RuntimeException("Böyle bir kullanıcı bulunmamaktadır.");
        } else if (!customer.get().getUserStatus().equals(EStatus.ACTIVE)) {
            throw new RuntimeException("Müşteri aktif değildir!");
        }
        return true;
    }

    public List<Customer> findAllCustomerRegistered() {
        List<Customer> customerList = customerRepository.findAllByUserStatusEquals(EStatus.ACTIVE);
        if (customerList.isEmpty()) {
            throw new RuntimeException("Aktif kayıtlı müşteri bulunamamaktadır");
        }else
            return customerList;
        }

    }








