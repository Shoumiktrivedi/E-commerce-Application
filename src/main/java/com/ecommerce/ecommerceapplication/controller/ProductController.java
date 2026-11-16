package com.ecommerce.ecommerceapplication.controller;

import com.ecommerce.ecommerceapplication.dto.ProductRequest;
import com.ecommerce.ecommerceapplication.entity.Product;
import com.ecommerce.ecommerceapplication.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(
            ProductService productService) {

        this.productService = productService;
    }

    @PostMapping
    public Product createProduct(
            @RequestBody ProductRequest request) {

        return productService.createProduct(request);
    }

    @GetMapping
    public List<Product> getAllProducts() {

        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(
            @PathVariable Long id) {

        return productService.getProductById(id);
    }
}