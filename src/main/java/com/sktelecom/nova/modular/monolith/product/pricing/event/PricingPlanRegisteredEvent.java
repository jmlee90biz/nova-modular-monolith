package com.sktelecom.nova.modular.monolith.product.pricing.event;

import java.util.UUID;

public record PricingPlanRegisteredEvent(UUID id, String name, String email) {
}
