package com.ecommerce.ecommerceapplication.dto;

import java.util.UUID;

public class SupplyHistoryRequest {

    private UUID lskid;
    private String nodeId;
    private Integer quantityAdded;

    public SupplyHistoryRequest() {
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

    public Integer getQuantityAdded() {
        return quantityAdded;
    }

    public void setQuantityAdded(Integer quantityAdded) {
        this.quantityAdded = quantityAdded;
    }
}