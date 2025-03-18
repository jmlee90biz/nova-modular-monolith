package com.sktelecom.nova.modular.monolith.customer.subscription.api;

import com.sktelecom.nova.modular.monolith.customer.profile.api.CustomerDto;

import com.sktelecom.nova.modular.monolith.product.catalog.api.ProductDto;
import com.sktelecom.nova.modular.monolith.product.pricing.api.PricingPlanDto;
import com.sktelecom.nova.modular.monolith.product.pricing.api.ProductPricingPlanDto;

import java.math.BigDecimal;
import java.util.UUID;

public record SubscriptionCustomerProductPricingPlanDto(
        UUID id, SubscriptionStatus subscriptionStatus,
        UUID customerId, String customerName, String customerEmail,
        UUID pricingPlanId, UUID productId, String productName, String productDescription, String pricingPlanName, BigDecimal price
    ) {

    public static SubscriptionCustomerProductPricingPlanDto join(CustomerDto customer, SubscriptionDto subscriptionDto) {
        return new SubscriptionCustomerProductPricingPlanDto(
                subscriptionDto.id(), subscriptionDto.subscriptionStatus(),
                customer.id(), customer.name(), customer.email(),
                subscriptionDto.pricingPlanId(), null, null, null, null, null);
    }

    public static SubscriptionCustomerProductPricingPlanDto join(ProductPricingPlanDto pricingPlan, SubscriptionCustomerProductPricingPlanDto subscriptionDto) {
        return new SubscriptionCustomerProductPricingPlanDto(
                subscriptionDto.id(), subscriptionDto.subscriptionStatus(),
                subscriptionDto.customerId(), subscriptionDto.customerName(), subscriptionDto.customerEmail(),
                subscriptionDto.pricingPlanId(), pricingPlan.productId(), pricingPlan.productName(), pricingPlan.productDescription(), pricingPlan.pricingPlanName(), pricingPlan.price());
    }
}
