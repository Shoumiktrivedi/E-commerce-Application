package com.ecommerce.ecommerceapplication.repository;

import com.ecommerce.ecommerceapplication.entity.DemandTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemandTransactionRepository
        extends JpaRepository<DemandTransaction, Long> {
}