package com.sktelecom.nova.modular.monolith.billing.invoice.api;

import com.sktelecom.nova.modular.monolith.customer.subscription.event.SubscriptionActivatedEvent;

public record InvoiceCreationRequest(SubscriptionActivatedEvent subscriptionActivatedEvent) {
    public static InvoiceCreationRequest createInvoiceCreationOrUpdateRequest(SubscriptionActivatedEvent subscriptionActivatedEvent) {
        return new InvoiceCreationRequest(subscriptionActivatedEvent);
    }
}
