
package com.ecommerce.ecommerceapplication.service;

import com.ecommerce.ecommerceapplication.dto.AtpResponse;
import com.ecommerce.ecommerceapplication.entity.SupplyLogistics;
import com.ecommerce.ecommerceapplication.entity.DemandSummary;
import com.ecommerce.ecommerceapplication.repository.SupplyLogisticsRepository;
import com.ecommerce.ecommerceapplication.repository.DemandSummaryRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AtpService {

    private final SupplyLogisticsRepository supplyLogisticsRepository;
    private final DemandSummaryRepository demandSummaryRepository;

    public AtpService(
            SupplyLogisticsRepository supplyLogisticsRepository,
            DemandSummaryRepository demandSummaryRepository) {

        this.supplyLogisticsRepository = supplyLogisticsRepository;
        this.demandSummaryRepository = demandSummaryRepository;
    }

    public AtpResponse calculateATP(UUID lskid, String nodeId) {

        int supply = supplyLogisticsRepository
                .findByCatalog_LskidAndNodeId(lskid, nodeId)
                .map(SupplyLogistics::getQuantity)
                .orElse(0);

        int allocated = demandSummaryRepository
                .findByCatalog_LskidAndNodeId(lskid, nodeId)
                .map(DemandSummary::getAllocated)
                .orElse(0);

        int atp = supply - allocated;

        return new AtpResponse(
                lskid.toString(),
                supply,
                allocated,
                atp
        );
    }
}
