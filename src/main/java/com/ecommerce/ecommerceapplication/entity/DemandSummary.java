package com.ecommerce.ecommerceapplication.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "demand_summary",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = {"lskid", "node_id"}
                )
        }
)
public class DemandSummary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long summaryId;

    @ManyToOne
    @JoinColumn(name = "lskid", nullable = false)
    private Catalog catalog;

    @Column(name = "node_id", nullable = false, length = 100)
    private String nodeId;

    @Column(nullable = false)
    private Integer allocated = 0;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    protected DemandSummary() {
    }

    public DemandSummary(
            Catalog catalog,
            String nodeId,
            Integer allocated) {

        this.catalog = catalog;
        this.nodeId = nodeId;
        this.allocated = allocated;
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

    public Long getSummaryId() {
        return summaryId;
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

    public Integer getAllocated() {
        return allocated;
    }

    public void setAllocated(Integer allocated) {
        this.allocated = allocated;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}