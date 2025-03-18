package com.sktelecom.nova.modular.monolith.customer.subscription.internal;

import com.sktelecom.nova.modular.monolith.customer.subscription.api.SubscriptionDto;

class SubscriptionMapper {
    static SubscriptionDto toSubscriptionDto(Subscription subscription) {
        return new SubscriptionDto(
                subscription.getId(),
                subscription.getCustomerId(),
                subscription.getPricingPlanId(),
                subscription.getSubscriptionStatus()
        );
    }
}
