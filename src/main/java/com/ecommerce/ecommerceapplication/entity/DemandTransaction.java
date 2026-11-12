
package com.ecommerce.ecommerceapplication.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "demand_transaction")
public class DemandTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    @Column(name = "node_id", nullable = false, length = 100)
    private String nodeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lskid_id", nullable = false)
    private Catalog catalog;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reservation_id", nullable = false)
    private Reservation reservation;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false, length = 20)
    private String status = "ACTIVE";

    protected DemandTransaction() {
    }

    public DemandTransaction(String nodeId, Catalog catalog,
                             Reservation reservation, Integer quantity) {
        this.nodeId = nodeId;
        this.catalog = catalog;
        this.reservation = reservation;
        this.quantity = quantity;
    }

    public Long getTransactionId() {
        return transactionId;
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

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
