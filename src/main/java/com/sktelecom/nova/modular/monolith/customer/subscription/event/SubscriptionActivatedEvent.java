package com.sktelecom.nova.modular.monolith.customer.subscription.event;

import com.sktelecom.nova.modular.monolith.customer.subscription.api.SubscriptionCustomerProductPricingPlanDto;
import com.sktelecom.nova.modular.monolith.customer.subscription.api.SubscriptionStatus;

import java.math.BigDecimal;
import java.util.UUID;

public record SubscriptionActivatedEvent(
//        UUID id, UUID customerId, UUID pricingPlanId, SubscriptionStatus subscriptionStatus
        UUID id, String subscriptionStatus,
        UUID customerId, String customerName, String customerEmail,
        UUID pricingPlanId, UUID productId, String productName, String productDescription, String pricingPlanName, BigDecimal price
) {

}
