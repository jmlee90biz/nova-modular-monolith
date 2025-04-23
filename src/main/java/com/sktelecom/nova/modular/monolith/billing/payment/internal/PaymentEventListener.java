package com.sktelecom.nova.modular.monolith.billing.payment.internal;

import com.sktelecom.nova.modular.monolith.billing.invoice.event.InvoiceClosedEvent;
import com.sktelecom.nova.modular.monolith.common.notification.event.NotificationRequestedEvent;
import com.sktelecom.nova.modular.monolith.customer.subscription.api.SubscriptionCustomerProductPricingPlanDto;
import com.sktelecom.nova.modular.monolith.customer.subscription.api.SubscriptionService;
import com.sktelecom.nova.modular.monolith.customer.subscription.event.SubscriptionActivatedEvent;
import com.sktelecom.nova.modular.monolith.shared.kernel.EventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentEventListener {
    //private final SubscriptionService subscriptionService;
    private final EventPublisher eventPublisher;

    @Async("taskExecutor")
    @ApplicationModuleListener
    void onInvoiceClosedEvent(final InvoiceClosedEvent invoiceClosedEvent) {
//        SubscriptionCustomerProductPricingPlanDto subscriptionCustomerProductPricingPlanDto =
//                subscriptionService.findSubscriptionCustomerProductPricingPlanById(subscriptionActivatedEvent.id());
//
//        eventPublisher.publish(
//                NotificationRequestedEvent.create(
//                        subscriptionCustomerProductPricingPlanDto.customerEmail(),
//                        "Subscription Activated",
//                        subscriptionCustomerProductPricingPlanDto.productName() + " " +
//                                subscriptionCustomerProductPricingPlanDto.pricingPlanName()
//                )
//        );
        eventPublisher.publish(
                NotificationRequestedEvent.create(
                        "",
                        "Customer Registered",
                        "Welcome!"
                )
        );
    }

}
