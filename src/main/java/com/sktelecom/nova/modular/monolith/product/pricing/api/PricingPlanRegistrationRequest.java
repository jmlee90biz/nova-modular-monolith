package com.sktelecom.nova.modular.monolith.product.pricing.api;

import java.math.BigDecimal;
import java.util.UUID;

public record PricingPlanRegistrationRequest(UUID productId, String name, BigDecimal price) {
}