package com.sktelecom.nova.modular.monolith.customer.subscription.internal;

import com.sktelecom.nova.modular.monolith.common.notification.event.NotificationRequestedEvent;
import com.sktelecom.nova.modular.monolith.customer.profile.api.CustomerDto;
import com.sktelecom.nova.modular.monolith.customer.profile.api.CustomerProfileService;
import com.sktelecom.nova.modular.monolith.customer.profile.event.CustomerRegisteredEvent;

import com.sktelecom.nova.modular.monolith.customer.subscription.api.SubscriptionCustomerProductPricingPlanDto;
import com.sktelecom.nova.modular.monolith.customer.subscription.api.SubscriptionService;
import com.sktelecom.nova.modular.monolith.customer.subscription.event.SubscriptionActivatedEvent;
import com.sktelecom.nova.modular.monolith.product.pricing.api.PricingPlanDto;
import com.sktelecom.nova.modular.monolith.product.pricing.api.ProductPricingPlanDto;
import com.sktelecom.nova.modular.monolith.product.pricing.api.ProductPricingService;
import com.sktelecom.nova.modular.monolith.shared.kernel.EventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SubscriptionEventListener {
    private final SubscriptionService subscriptionService;
    private final EventPublisher eventPublisher;

    @Async("taskExecutor")
    @ApplicationModuleListener
    void onSubscriptionActivatedEvent(final SubscriptionActivatedEvent subscriptionActivatedEvent) {
        SubscriptionCustomerProductPricingPlanDto subscriptionCustomerProductPricingPlanDto =
                subscriptionService.findSubscriptionCustomerProductPricingPlanById(subscriptionActivatedEvent.id());

        eventPublisher.publish(
                NotificationRequestedEvent.create(
                        subscriptionCustomerProductPricingPlanDto.customerEmail(),
                        "Subscription Activated",
                        subscriptionCustomerProductPricingPlanDto.productName() + " " +
                                subscriptionCustomerProductPricingPlanDto.pricingPlanName()
                )
        );
    }
}
