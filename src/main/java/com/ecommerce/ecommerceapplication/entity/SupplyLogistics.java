
package com.ecommerce.ecommerceapplication.entity;

import jakarta.persistence.*;

@Entity
@Table(
        name = "supply_logistics",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = {"lskid", "node_id"}
                )
        }
)
public class SupplyLogistics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long logisticsId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lskid", nullable = false)
    private Catalog catalog;

    @Column(name = "node_id", nullable = false, length = 100)
    private String nodeId;

    @Column(nullable = false)
    private Integer quantity = 0;

    protected SupplyLogistics() {
    }

    public SupplyLogistics(Catalog catalog, String nodeId, Integer quantity) {
        this.catalog = catalog;
        this.nodeId = nodeId;
        this.quantity = quantity;
    }

    public Long getLogisticsId() {
        return logisticsId;
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
}
