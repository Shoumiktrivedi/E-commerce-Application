package com.ecommerce.ecommerceapplication.service;

import com.ecommerce.ecommerceapplication.dto.CatalogRequest;
import com.ecommerce.ecommerceapplication.entity.Catalog;
import com.ecommerce.ecommerceapplication.entity.Product;
import com.ecommerce.ecommerceapplication.repository.CatalogRepository;
import com.ecommerce.ecommerceapplication.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CatalogService {

    private final CatalogRepository catalogRepository;
    private final ProductRepository productRepository;

    public CatalogService(
            CatalogRepository catalogRepository,
            ProductRepository productRepository) {

        this.catalogRepository = catalogRepository;
        this.productRepository = productRepository;
    }

    public Catalog createCatalog(CatalogRequest request) {

        Product product = productRepository.findById(
                        request.getProductId())
                .orElseThrow(() ->
                        new RuntimeException("Product not found"));

        Catalog catalog = new Catalog(
                product,
                request.getName(),
                request.getSize()
        );

        return catalogRepository.save(catalog);
    }

    public List<Catalog> getAllCatalogs() {
        return catalogRepository.findAll();
    }

    public Catalog getCatalog(UUID lskid) {

        return catalogRepository.findById(lskid)
                .orElseThrow(() ->
                        new RuntimeException("Catalog not found"));
    }
}
