package com.sktelecom.nova.modular.monolith.product.pricing.api;

import com.sktelecom.nova.modular.monolith.product.catalog.api.ProductDto;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductPricingPlanDto(
        UUID id, UUID productId, String productName, String productDescription, String pricingPlanName, BigDecimal price) {
    public static ProductPricingPlanDto join(ProductDto product, PricingPlanDto pricingPlan) {
        return new ProductPricingPlanDto(pricingPlan.id(), product.id(), product.name(), product.description(),
                pricingPlan.name(), pricingPlan.price());
    }
}
