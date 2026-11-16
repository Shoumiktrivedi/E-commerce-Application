package com.ecommerce.ecommerceapplication.repository;

import com.ecommerce.ecommerceapplication.entity.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CatalogRepository
        extends JpaRepository<Catalog, UUID> {
}