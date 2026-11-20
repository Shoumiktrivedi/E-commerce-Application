package com.ecommerce.ecommerceapplication.service;

import com.ecommerce.ecommerceapplication.dto.SupplyRequest;
import com.ecommerce.ecommerceapplication.entity.Catalog;
import com.ecommerce.ecommerceapplication.entity.Supply;
import com.ecommerce.ecommerceapplication.repository.CatalogRepository;
import com.ecommerce.ecommerceapplication.repository.SupplyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SupplyService {

    private final SupplyRepository supplyRepository;
    private final CatalogRepository catalogRepository;

    public SupplyService(
            SupplyRepository supplyRepository,
            CatalogRepository catalogRepository) {

        this.supplyRepository = supplyRepository;
        this.catalogRepository = catalogRepository;
    }

    public Supply createSupply(SupplyRequest request) {

        Catalog catalog = catalogRepository.findById(
                        request.getLskid())
                .orElseThrow(() ->
                        new RuntimeException("Catalog not found"));

        Supply supply = new Supply(
                catalog,
                request.getNodeId(),
                request.getQuantity()
        );

        return supplyRepository.save(supply);
    }

    public List<Supply> getAllSupply() {
        return supplyRepository.findAll();
    }

    public Supply getSupply(Long id) {

        return supplyRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Supply not found"));
    }
}