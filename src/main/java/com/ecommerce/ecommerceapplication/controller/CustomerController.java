package com.ecommerce.ecommerceapplication.controller;

import com.ecommerce.ecommerceapplication.dto.CustomerRequest;
import com.ecommerce.ecommerceapplication.entity.Customer;
import com.ecommerce.ecommerceapplication.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(
            CustomerService customerService) {

        this.customerService = customerService;
    }

    @PostMapping
    public Customer createCustomer(
            @RequestBody CustomerRequest request) {

        return customerService.createCustomer(request);
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustomer(
            @PathVariable Long id) {

        return customerService.getCustomer(id);
    }
}