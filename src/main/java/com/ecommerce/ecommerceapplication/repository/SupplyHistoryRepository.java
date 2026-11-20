package com.ecommerce.ecommerceapplication.repository;

import com.ecommerce.ecommerceapplication.entity.SupplyHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplyHistoryRepository
        extends JpaRepository<SupplyHistory, Long> {
}