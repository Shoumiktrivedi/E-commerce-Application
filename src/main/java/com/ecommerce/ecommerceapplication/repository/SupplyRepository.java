package com.ecommerce.ecommerceapplication.repository;

import com.ecommerce.ecommerceapplication.entity.Supply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SupplyRepository
        extends JpaRepository<Supply, Long> {

    Optional<Supply> findByCatalog_LskidAndNodeId(
            UUID lskid,
            String nodeId
    );
}