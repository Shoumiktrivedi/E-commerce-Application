
package com.ecommerce.ecommerceapplication.controller;

import com.ecommerce.ecommerceapplication.dto.AtpResponse;
import com.ecommerce.ecommerceapplication.service.AtpService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/atp")
public class AtpController {

    private final AtpService atpService;

    public AtpController(AtpService atpService) {
        this.atpService = atpService;
    }

    @GetMapping("/{lskid}/{nodeId}")
    public AtpResponse getATP(
            @PathVariable UUID lskid,
            @PathVariable String nodeId) {

        return atpService.calculateATP(lskid, nodeId);
    }
}
