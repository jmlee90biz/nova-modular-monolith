package com.sktelecom.nova.modular.monolith.customer.subscription.internal;

import com.sktelecom.nova.modular.monolith.customer.subscription.api.SubscriptionCustomerProductPricingPlanDto;
import com.sktelecom.nova.modular.monolith.customer.subscription.api.SubscriptionDto;
import com.sktelecom.nova.modular.monolith.customer.subscription.api.SubscriptionService;
import com.sktelecom.nova.modular.monolith.customer.subscription.api.SubscriptionActivateRequest;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/customer/subscription")
@Tag(name="customer-subscription")
class SubscriptionController {
    private final SubscriptionService subscriptionService;

    @GetMapping("/subscriptions/{id}")
    public SubscriptionDto getSubscriptionById(@PathVariable(name="id") UUID customerId) {
        return subscriptionService.getSubscriptionById(customerId);
    }

    @PostMapping("/subscriptions")
    public SubscriptionDto activateSubscription(@RequestBody SubscriptionActivateRequest customerRegistrationRequest) {
        return subscriptionService.activateSubscription(customerRegistrationRequest);
    }

    @GetMapping("/subscriptions")
    public List<SubscriptionDto> getAllSubscriptions() {
        return subscriptionService.findAllSubscriptions();
    }

    @GetMapping("/subscription-customer-product-pricing-plan/{id}")
    public SubscriptionCustomerProductPricingPlanDto findSubscriptionCustomerProductPricingPlanById(@PathVariable(name="id") UUID subscriptionId) {
        return subscriptionService.findSubscriptionCustomerProductPricingPlanById(subscriptionId);
    }

    @GetMapping("/subscription-customer-product-pricing-plan")
    public List<SubscriptionCustomerProductPricingPlanDto> findAllSubscriptionCustomerProductPricings() {
        return subscriptionService.findAllSubscriptionCustomerProductPricingPlans();
    }
}
