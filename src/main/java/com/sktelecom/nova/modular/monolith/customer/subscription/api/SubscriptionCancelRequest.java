package com.sktelecom.nova.modular.monolith.customer.subscription.api;

import java.util.UUID;

public record SubscriptionCancelRequest(UUID customerId, UUID pricingPlanId) {
}