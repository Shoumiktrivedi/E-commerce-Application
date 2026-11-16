package com.ecommerce.ecommerceapplication.repository;

import com.ecommerce.ecommerceapplication.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository
        extends JpaRepository<Product, Long> {
}