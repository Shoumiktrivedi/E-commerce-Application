package com.ecommerce.ecommerceapplication.service;

import com.ecommerce.ecommerceapplication.dto.CustomerRequest;
import com.ecommerce.ecommerceapplication.entity.Customer;
import com.ecommerce.ecommerceapplication.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer createCustomer(CustomerRequest request) {

        Customer customer = new Customer(
                request.getCustomerName(),
                request.getEmail()
        );

        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomer(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Customer not found"));
    }
}