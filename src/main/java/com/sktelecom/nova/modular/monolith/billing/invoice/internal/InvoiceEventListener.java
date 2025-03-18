package com.sktelecom.nova.modular.monolith.billing.invoice.internal;

import com.sktelecom.nova.modular.monolith.billing.invoice.api.InvoiceCreationRequest;
import com.sktelecom.nova.modular.monolith.billing.invoice.api.InvoiceService;
import com.sktelecom.nova.modular.monolith.customer.subscription.event.SubscriptionActivatedEvent;
import com.sktelecom.nova.modular.monolith.shared.kernel.EventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InvoiceEventListener {
    private final InvoiceService invoiceService;
    private final EventPublisher eventPublisher;

    //@Async("taskExecutor")
    @ApplicationModuleListener
    void onSubscriptionActivatedEvent(final SubscriptionActivatedEvent subscriptionActivatedEvent) {
        invoiceService.createInvoice(InvoiceCreationRequest.createInvoiceCreationOrUpdateRequest(subscriptionActivatedEvent));
    }
}
