
package com.ecommerce.ecommerceapplication.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "supply")
public class Supply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pId;

    @Column(name = "node_id", nullable = false, length = 100)
    private String nodeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lskid", nullable = false)
    private Catalog catalog;

    @Column(nullable = false)
    private Integer quantity = 0;

    protected Supply() {
    }

    public Supply(String nodeId, Catalog catalog, Integer quantity) {
        this.nodeId = nodeId;
        this.catalog = catalog;
        this.quantity = quantity;
    }

    public Long getPId() {
        return pId;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
