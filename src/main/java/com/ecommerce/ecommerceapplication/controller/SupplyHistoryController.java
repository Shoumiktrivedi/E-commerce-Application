package com.ecommerce.ecommerceapplication.controller;

import com.ecommerce.ecommerceapplication.dto.SupplyHistoryRequest;
import com.ecommerce.ecommerceapplication.entity.SupplyHistory;
import com.ecommerce.ecommerceapplication.service.SupplyHistoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/supply-history")
public class SupplyHistoryController {

    private final SupplyHistoryService supplyHistoryService;

    public SupplyHistoryController(
            SupplyHistoryService supplyHistoryService) {

        this.supplyHistoryService = supplyHistoryService;
    }

    @PostMapping
    public SupplyHistory addInventory(
            @RequestBody SupplyHistoryRequest request) {

        return supplyHistoryService.addInventory(request);
    }

    @GetMapping
    public List<SupplyHistory> getAllSupplyHistory() {

        return supplyHistoryService.getAllSupplyHistory();
    }
}