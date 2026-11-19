package com.ecommerce.ecommerceapplication.service;

import com.ecommerce.ecommerceapplication.dto.AtpResponse;
import com.ecommerce.ecommerceapplication.entity.DemandSummary;
import com.ecommerce.ecommerceapplication.entity.Supply;
import com.ecommerce.ecommerceapplication.repository.DemandSummaryRepository;
import com.ecommerce.ecommerceapplication.repository.SupplyRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AtpService {

    private final SupplyRepository supplyRepository;
    private final DemandSummaryRepository demandSummaryRepository;

    public AtpService(
            SupplyRepository supplyRepository,
            DemandSummaryRepository demandSummaryRepository) {

        this.supplyRepository = supplyRepository;
        this.demandSummaryRepository = demandSummaryRepository;
    }

    public AtpResponse calculateATP(UUID lskid, String nodeId) {

        int supply = supplyRepository
                .findByCatalog_LskidAndNodeId(lskid, nodeId)
                .map(Supply::getQuantity)
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