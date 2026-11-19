package com.ecommerce.ecommerceapplication.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Check;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "supply",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = {"lskid", "node_id"}
                )
        }
)
@Check(constraints = "quantity >= 0")
public class Supply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long supplyId;

    @ManyToOne
    @JoinColumn(name = "lskid", nullable = false)
    private Catalog catalog;

    @Column(name = "node_id", nullable = false, length = 100)
    private String nodeId;

    @Column(nullable = false)
    private Integer quantity = 0;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    protected Supply() {
    }

    public Supply(
            Catalog catalog,
            String nodeId,
            Integer quantity) {

        this.catalog = catalog;
        this.nodeId = nodeId;
        this.quantity = quantity;
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

    public Long getSupplyId() {
        return supplyId;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}