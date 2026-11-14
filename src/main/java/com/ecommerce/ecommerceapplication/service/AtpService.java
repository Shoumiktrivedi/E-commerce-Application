package com.ecommerce.ecommerceapplication.service;

import com.ecommerce.ecommerceapplication.dto.AtpResponse;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class AtpService {


    public AtpResponse calculateATP(String lskid) {

        int supply = 100;
        int allocated = 35;

        int atp = supply - allocated;

        System.out.println("Calculating ATP...");

        return new AtpResponse(
                lskid,
                supply,
                allocated,
                atp
        );
    }
}