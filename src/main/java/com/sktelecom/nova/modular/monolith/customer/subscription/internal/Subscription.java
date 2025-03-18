package com.sktelecom.nova.modular.monolith.customer.subscription.internal;

import com.sktelecom.nova.modular.monolith.customer.subscription.api.SubscriptionCustomerProductPricingPlanDto;
import com.sktelecom.nova.modular.monolith.customer.subscription.api.SubscriptionStatus;
import com.sktelecom.nova.modular.monolith.customer.subscription.event.SubscriptionActivatedEvent;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "subscription", schema = "customer")
class Subscription {
    @Id
    private UUID id;

    private UUID customerId;
    private UUID pricingPlanId;

    @Enumerated(EnumType.STRING)
    private SubscriptionStatus subscriptionStatus;

    public Subscription(UUID customerId, UUID pricingPlanId, SubscriptionStatus subscriptionStatus) {
        this.id = UUID.randomUUID();
        this.customerId = customerId;
        this.pricingPlanId = pricingPlanId;
        this.subscriptionStatus = subscriptionStatus;
    }

    public void activate() {
        this.subscriptionStatus = SubscriptionStatus.ACTIVE;
    }

    public void cancel() {
        this.subscriptionStatus = SubscriptionStatus.CANCELED;
    }

    static Subscription createActivatedSubscription(UUID customerId, UUID productId) {
        return new Subscription(customerId, productId, SubscriptionStatus.ACTIVE);
    }

    SubscriptionActivatedEvent createSubscriptionActivatedEvent(SubscriptionCustomerProductPricingPlanDto subscriptionCustomerProductPricingPlanDto) {
        return new SubscriptionActivatedEvent(
                    subscriptionCustomerProductPricingPlanDto.id(), subscriptionCustomerProductPricingPlanDto.subscriptionStatus().name(),
                    subscriptionCustomerProductPricingPlanDto.customerId(), subscriptionCustomerProductPricingPlanDto.customerName(), subscriptionCustomerProductPricingPlanDto.customerEmail(),
                    subscriptionCustomerProductPricingPlanDto.pricingPlanId(), subscriptionCustomerProductPricingPlanDto.productId(),
                    subscriptionCustomerProductPricingPlanDto.productName(), subscriptionCustomerProductPricingPlanDto.productDescription(),
                    subscriptionCustomerProductPricingPlanDto.pricingPlanName(), subscriptionCustomerProductPricingPlanDto.price()
        );
    }
}