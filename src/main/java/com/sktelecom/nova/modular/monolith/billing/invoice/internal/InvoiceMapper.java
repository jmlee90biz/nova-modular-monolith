package com.sktelecom.nova.modular.monolith.billing.invoice.internal;

import com.sktelecom.nova.modular.monolith.billing.invoice.api.InvoiceDto;
import com.sktelecom.nova.modular.monolith.customer.subscription.api.SubscriptionStatus;

import java.math.BigDecimal;
import java.util.UUID;

class InvoiceMapper {
    static InvoiceDto toInvoiceDto(Invoice invoice) {
        return new InvoiceDto(invoice.getId(), invoice.getCustomerId(), invoice.getAmount(),
                invoice.getSubscriptionStatus(), invoice.getCustomerName(), invoice.getCustomerEmail(),
                invoice.getPricingPlanId(), invoice.getProductId(), invoice.getProductName(), invoice.getProductDescription(),
                invoice.getPricingPlanName(), invoice.getPrice());
    }
}
