
package com.ecommerce.ecommerceapplication.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

@Entity
@Table(name = "customers")
public class Customer {

    // Primary Key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    // Customer Details
    @NotBlank
    @Column(nullable = false, length = 100)
    private String customerName;

    @NotBlank
    @Email
    @Column(nullable = false, unique = true, length = 255)
    private String email;

    // Creation Timestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    // Default constructor required by JPA
    protected Customer() {
    }

    // Constructor
    public Customer(String customerName, String email) {
        this.customerName = customerName;
        this.email = email;
    }

    // Set creation timestamp before inserting
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    // Getters and Setters

    public Long getCustomerId() {
        return customerId;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
