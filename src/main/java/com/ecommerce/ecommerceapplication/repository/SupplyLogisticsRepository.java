
package com.ecommerce.ecommerceapplication.repository;

import com.ecommerce.ecommerceapplication.entity.SupplyLogistics;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SupplyLogisticsRepository
        extends JpaRepository<SupplyLogistics, Long> {

    Optional<SupplyLogistics> findByCatalog_LskidAndNodeId(
            UUID lskid,
            String nodeId
    );
}

