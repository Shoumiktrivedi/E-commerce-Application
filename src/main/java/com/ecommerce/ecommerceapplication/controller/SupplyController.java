package com.ecommerce.ecommerceapplication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/supply")
public class SupplyController {

    @GetMapping
    public String getSupply() {
        return "Supply API Working";
    }
}