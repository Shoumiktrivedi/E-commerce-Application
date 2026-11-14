package com.ecommerce.ecommerceapplication.controller;

import com.ecommerce.ecommerceapplication.dto.AtpResponse;
import com.ecommerce.ecommerceapplication.service.AtpService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/atp")
public class AtpController {

    private final AtpService atpService;

    public AtpController(AtpService atpService) {
        this.atpService = atpService;
    }

    @GetMapping("/{lskid}")
    public AtpResponse getATP(
            @PathVariable String lskid) {

        return atpService.calculateATP(lskid);
    }
}