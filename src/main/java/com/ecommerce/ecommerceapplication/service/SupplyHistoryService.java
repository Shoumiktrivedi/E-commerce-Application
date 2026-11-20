package com.ecommerce.ecommerceapplication.service;

import com.ecommerce.ecommerceapplication.dto.SupplyHistoryRequest;
import com.ecommerce.ecommerceapplication.entity.Catalog;
import com.ecommerce.ecommerceapplication.entity.Supply;
import com.ecommerce.ecommerceapplication.entity.SupplyHistory;
import com.ecommerce.ecommerceapplication.repository.CatalogRepository;
import com.ecommerce.ecommerceapplication.repository.SupplyHistoryRepository;
import com.ecommerce.ecommerceapplication.repository.SupplyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplyHistoryService {

    private final SupplyHistoryRepository supplyHistoryRepository;
    private final SupplyRepository supplyRepository;
    private final CatalogRepository catalogRepository;

    public SupplyHistoryService(
            SupplyHistoryRepository supplyHistoryRepository,
            SupplyRepository supplyRepository,
            CatalogRepository catalogRepository) {

        this.supplyHistoryRepository = supplyHistoryRepository;
        this.supplyRepository = supplyRepository;
        this.catalogRepository = catalogRepository;
    }

    public SupplyHistory addInventory(
            SupplyHistoryRequest request) {

        Catalog catalog = catalogRepository
                .findById(request.getLskid())
                .orElseThrow(() ->
                        new RuntimeException("Catalog not found"));

        SupplyHistory history =
                new SupplyHistory(
                        catalog,
                        request.getNodeId(),
                        request.getQuantityAdded()
                );

        supplyHistoryRepository.save(history);

        Supply supply = supplyRepository
                .findByCatalog_LskidAndNodeId(
                        request.getLskid(),
                        request.getNodeId()
                )
                .orElse(
                        new Supply(
                                catalog,
                                request.getNodeId(),
                                0
                        )
                );

        supply.setQuantity(
                supply.getQuantity()
                        + request.getQuantityAdded()
        );

        supplyRepository.save(supply);

        return history;
    }

    public List<SupplyHistory> getAllSupplyHistory() {
        return supplyHistoryRepository.findAll();
    }
}