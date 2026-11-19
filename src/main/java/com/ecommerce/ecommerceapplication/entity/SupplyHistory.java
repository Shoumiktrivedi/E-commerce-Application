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
    private Long historyId;

    @ManyToOne
    @JoinColumn(name = "lskid", nullable = false)
    private Catalog catalog;

    @Column(name = "node_id", nullable = false, length = 100)
    private String nodeId;

    @Column(nullable = false)
    private Integer quantityAdded;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    protected SupplyHistory() {
    }

    public SupplyHistory(Catalog catalog,
                         String nodeId,
                         Integer quantityAdded) {
        this.catalog = catalog;
        this.nodeId = nodeId;
        this.quantityAdded = quantityAdded;
    }

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    public Long getHistoryId() {
        return historyId;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
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

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}