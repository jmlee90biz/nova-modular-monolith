package com.sktelecom.nova.modular.monolith.product.pricing.internal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "price_plan", schema = "product")
class PricingPlan {
    @Id
    private UUID id;

    private UUID productId;
    private String name;
    private BigDecimal price;

    public PricingPlan(UUID productId, String name, BigDecimal price) {
        this.id = UUID.randomUUID();
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    static PricingPlan createPricingPlan(UUID productId, String name, BigDecimal price) {
        return new PricingPlan(productId, name, price);
    }

    PricingPlanRegisteredEvent createPricingPlanRegisteredEvent() {
        return new PricingPlanRegisteredEvent(id, productId, name, price);
    }
}