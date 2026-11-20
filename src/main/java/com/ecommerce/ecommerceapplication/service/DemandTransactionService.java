package com.ecommerce.ecommerceapplication.service;

import com.ecommerce.ecommerceapplication.dto.DemandTransactionRequest;
import com.ecommerce.ecommerceapplication.entity.Catalog;
import com.ecommerce.ecommerceapplication.entity.Customer;
import com.ecommerce.ecommerceapplication.entity.DemandSummary;
import com.ecommerce.ecommerceapplication.entity.DemandTransaction;
import com.ecommerce.ecommerceapplication.repository.CatalogRepository;
import com.ecommerce.ecommerceapplication.repository.CustomerRepository;
import com.ecommerce.ecommerceapplication.repository.DemandSummaryRepository;
import com.ecommerce.ecommerceapplication.repository.DemandTransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemandTransactionService {

    private final DemandTransactionRepository demandTransactionRepository;
    private final DemandSummaryRepository demandSummaryRepository;
    private final CustomerRepository customerRepository;
    private final CatalogRepository catalogRepository;

    public DemandTransactionService(
            DemandTransactionRepository demandTransactionRepository,
            DemandSummaryRepository demandSummaryRepository,
            CustomerRepository customerRepository,
            CatalogRepository catalogRepository) {

        this.demandTransactionRepository = demandTransactionRepository;
        this.demandSummaryRepository = demandSummaryRepository;
        this.customerRepository = customerRepository;
        this.catalogRepository = catalogRepository;
    }

    public DemandTransaction createDemand(
            DemandTransactionRequest request) {

        Customer customer = customerRepository
                .findById(request.getCustomerId())
                .orElseThrow(() ->
                        new RuntimeException("Customer not found"));

        Catalog catalog = catalogRepository
                .findById(request.getLskid())
                .orElseThrow(() ->
                        new RuntimeException("Catalog not found"));

        DemandTransaction transaction =
                new DemandTransaction(
                        customer,
                        catalog,
                        request.getNodeId(),
                        request.getQuantity()
                );

        demandTransactionRepository.save(transaction);

        DemandSummary summary =
                demandSummaryRepository
                        .findByCatalog_LskidAndNodeId(
                                request.getLskid(),
                                request.getNodeId()
                        )
                        .orElse(
                                new DemandSummary(
                                        catalog,
                                        request.getNodeId(),
                                        0
                                )
                        );

        summary.setAllocated(
                summary.getAllocated()
                        + request.getQuantity()
        );

        demandSummaryRepository.save(summary);

        return transaction;
    }

    public List<DemandTransaction> getAllTransactions() {
        return demandTransactionRepository.findAll();
    }
}