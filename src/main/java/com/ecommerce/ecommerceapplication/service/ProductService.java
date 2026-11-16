package com.ecommerce.ecommerceapplication.service;

import com.ecommerce.ecommerceapplication.dto.ProductRequest;
import com.ecommerce.ecommerceapplication.entity.Product;
import com.ecommerce.ecommerceapplication.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(
            ProductRepository productRepository) {

        this.productRepository = productRepository;
    }

    public Product createProduct(
            ProductRequest request) {

        Product product =
                new Product(request.getProductName());

        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {

        return productRepository.findAll();
    }

    public Product getProductById(
            Long id) {

        return productRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Product not found"));
    }
}