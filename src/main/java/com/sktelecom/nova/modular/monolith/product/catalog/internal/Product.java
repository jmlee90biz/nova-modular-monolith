package com.sktelecom.nova.modular.monolith.product.catalog.internal;

import com.sktelecom.nova.modular.monolith.product.catalog.event.ProductRegisteredEvent;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "product", schema = "product")
class Product {
    @Id
    private UUID id;

    private String name;
    private String description;

    public Product(String name, String description) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.description = description;
    }

    static Product createProduct(String name, String description) {
        return new Product(name, description);
    }

    ProductRegisteredEvent createProductRegisteredEvent() {
        return new ProductRegisteredEvent(id, name, description);
    }
}