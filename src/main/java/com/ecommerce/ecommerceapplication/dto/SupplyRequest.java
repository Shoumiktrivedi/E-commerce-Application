package com.ecommerce.ecommerceapplication.dto;

import java.util.UUID;

public class SupplyRequest {

    private UUID lskid;
    private String nodeId;
    private Integer quantity;

    public SupplyRequest() {
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