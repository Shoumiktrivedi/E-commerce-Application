package com.ecommerce.ecommerceapplication.dto;

public class AtpResponse {

    private String lskid;
    private int supply;
    private int allocated;
    private int atp;

    public AtpResponse(String lskid,
                       int supply,
                       int allocated,
                       int atp) {
        this.lskid = lskid;
        this.supply = supply;
        this.allocated = allocated;
        this.atp = atp;
    }

    public String getLskid() {
        return lskid;
    }

    public int getSupply() {
        return supply;
    }

    public int getAllocated() {
        return allocated;
    }

    public int getAtp() {
        return atp;
    }
}