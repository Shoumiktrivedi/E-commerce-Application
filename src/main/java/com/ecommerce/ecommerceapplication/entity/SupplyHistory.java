
package com.ecommerce.ecommerceapplication.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Check;

import java.time.LocalDateTime;

@Entity
@Table(name = "supply_history")
@Check(constraints = "quantity_added > 0")
public class SupplyHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long supplyId;

    // Relationship with Product
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(nullable = false)
    private Integer quantityAdded;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    // Default constructor required by JPA
    protected SupplyHistory() {
    }

    // Constructor
    public SupplyHistory(Product product, Integer quantityAdded) {
        this.product = product;
        this.quantityAdded = quantityAdded;
    }

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    // Getters and Setters

    public Long getSupplyId() {
        return supplyId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantityAdded() {
        return quantityAdded;
    }

    public void setQuantityAdded(Integer quantityAdded) {
        this.quantityAdded = quantityAdded;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
