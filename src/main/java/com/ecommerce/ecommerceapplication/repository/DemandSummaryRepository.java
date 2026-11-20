package com.ecommerce.ecommerceapplication.repository;

import com.ecommerce.ecommerceapplication.entity.DemandSummary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface DemandSummaryRepository
        extends JpaRepository<DemandSummary, Long> {

    Optional<DemandSummary> findByCatalog_LskidAndNodeId(
            UUID lskid,
            String nodeId
    );
}