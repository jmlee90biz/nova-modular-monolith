package com.sktelecom.nova.modular.monolith.product.pricing.internal;

import java.math.BigDecimal;
import java.util.UUID;

record PricingPlanRegisteredEvent(UUID id, UUID productId, String name, BigDecimal price) {
}
