package com.sktelecom.nova.modular.monolith.billing.invoice.api;

import com.sktelecom.nova.modular.monolith.customer.subscription.api.SubscriptionStatus;

import java.math.BigDecimal;
import java.util.UUID;

public record InvoiceDto(
            UUID id,
            UUID customerId, BigDecimal amount,

            String subscriptionStatus, String customerName, String customerEmail,

            UUID pricingPlanId,
            UUID productId,
            String productName,
            String productDescription,
            String pricingPlanName,
            BigDecimal price
) {
}
