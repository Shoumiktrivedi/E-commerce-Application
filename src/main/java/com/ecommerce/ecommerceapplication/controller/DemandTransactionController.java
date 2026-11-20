package com.ecommerce.ecommerceapplication.controller;

import com.ecommerce.ecommerceapplication.dto.DemandTransactionRequest;
import com.ecommerce.ecommerceapplication.entity.DemandTransaction;
import com.ecommerce.ecommerceapplication.service.DemandTransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/demand-transaction")
public class DemandTransactionController {

    private final DemandTransactionService demandTransactionService;

    public DemandTransactionController(
            DemandTransactionService demandTransactionService) {

        this.demandTransactionService = demandTransactionService;
    }

    @PostMapping
    public DemandTransaction createDemand(
            @RequestBody DemandTransactionRequest request) {

        return demandTransactionService.createDemand(request);
    }

    @GetMapping
    public List<DemandTransaction> getAllTransactions() {

        return demandTransactionService.getAllTransactions();
    }
}