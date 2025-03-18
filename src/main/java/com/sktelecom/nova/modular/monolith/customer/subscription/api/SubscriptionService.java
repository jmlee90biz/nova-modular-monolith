package com.sktelecom.nova.modular.monolith.customer.subscription.api;


import java.util.List;
import java.util.UUID;

public interface SubscriptionService {
    SubscriptionDto activateSubscription(SubscriptionActivateRequest subscriptionActivateRequest);
    SubscriptionDto getSubscriptionById(UUID subscriptionId);
    List<SubscriptionDto> findAllSubscriptions();

    List<SubscriptionCustomerProductPricingPlanDto> findAllSubscriptionCustomerProductPricingPlans();
    SubscriptionCustomerProductPricingPlanDto findSubscriptionCustomerProductPricingPlanById(UUID subscriptionId);
}
