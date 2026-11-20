package com.ecommerce.ecommerceapplication.dto;

public class CustomerRequest {

    private String customerName;
    private String email;

    public CustomerRequest() {
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}