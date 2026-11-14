package com.ecommerce.ecommerceapplication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/demand")
public class DemandController {

    @GetMapping
    public String getDemand() {
        return "Demand API Working";
    }
}