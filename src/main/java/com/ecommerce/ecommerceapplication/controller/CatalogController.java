package com.ecommerce.ecommerceapplication.controller;

import com.ecommerce.ecommerceapplication.dto.CatalogRequest;
import com.ecommerce.ecommerceapplication.entity.Catalog;
import com.ecommerce.ecommerceapplication.service.CatalogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/catalog")
public class CatalogController {

    private final CatalogService catalogService;

    public CatalogController(
            CatalogService catalogService) {

        this.catalogService = catalogService;
    }

    @PostMapping
    public Catalog createCatalog(
            @RequestBody CatalogRequest request) {

        return catalogService.createCatalog(request);
    }

    @GetMapping
    public List<Catalog> getAllCatalogs() {

        return catalogService.getAllCatalogs();
    }

    @GetMapping("/{lskid}")
    public Catalog getCatalog(
            @PathVariable UUID lskid) {

        return catalogService.getCatalog(lskid);
    }
}