
package com.ecommerce.ecommerceapplication.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "catalog")
public class Catalog {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID lskid;

    // Relationship with Product
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(nullable = false, length = 150)
    private String name;

    @Column(nullable = false, length = 50)
    private String size;

    // Default constructor required by JPA
    protected Catalog() {
    }

    // Constructor
    public Catalog(Product product, String name, String size) {
        this.product = product;
        this.name = name;
        this.size = size;
    }

    // Getters and Setters

    public UUID getLskid() {
        return lskid;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
