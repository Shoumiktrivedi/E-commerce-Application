package com.ecommerce.ecommerceapplication.dto;

import java.util.UUID;

public class DemandTransactionRequest {

    private Long customerId;

    private UUID lskid;

    private String nodeId;

    private Integer quantity;

    public DemandTransactionRequest() {
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public UUID getLskid() {
        return lskid;
    }

    public void setLskid(UUID lskid) {
        this.lskid = lskid;
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