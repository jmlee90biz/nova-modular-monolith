package com.sktelecom.nova.modular.monolith.customer.subscription.api;

import java.util.UUID;

public record SubscriptionActivateRequest(UUID customerId, UUID pricingPlanId) {
}