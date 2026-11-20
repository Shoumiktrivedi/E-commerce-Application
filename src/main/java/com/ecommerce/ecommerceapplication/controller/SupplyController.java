package com.ecommerce.ecommerceapplication.controller;

import com.ecommerce.ecommerceapplication.dto.SupplyRequest;
import com.ecommerce.ecommerceapplication.entity.Supply;
import com.ecommerce.ecommerceapplication.service.SupplyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/supply")
public class SupplyController {

    private final SupplyService supplyService;

    public SupplyController(
            SupplyService supplyService) {

        this.supplyService = supplyService;
    }

    @PostMapping
    public Supply createSupply(
            @RequestBody SupplyRequest request) {

        return supplyService.createSupply(request);
    }

    @GetMapping
    public List<Supply> getAllSupply() {

        return supplyService.getAllSupply();
    }

    @GetMapping("/{id}")
    public Supply getSupply(
            @PathVariable Long id) {

        return supplyService.getSupply(id);
    }
}