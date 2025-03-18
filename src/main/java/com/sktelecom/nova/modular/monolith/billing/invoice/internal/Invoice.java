package com.sktelecom.nova.modular.monolith.billing.invoice.internal;

import com.sktelecom.nova.modular.monolith.billing.invoice.event.InvoiceCreatedEvent;
import com.sktelecom.nova.modular.monolith.customer.subscription.api.SubscriptionStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "invoice", schema = "billing")
class Invoice {
    @Id
    private UUID id;

    private UUID customerId;
    private BigDecimal amount;

    private String subscriptionStatus;
    private String customerName;
    private String customerEmail;

    private UUID pricingPlanId;
    private UUID productId;
    private String productName;
    private String productDescription;
    private String pricingPlanName;
    private BigDecimal price;

    public Invoice(UUID customerId, BigDecimal amount,
                   String subscriptionStatus,  String customerName, String customerEmail,
                   UUID pricingPlanId, UUID productId, String productName, String productDescription, String pricingPlanName, BigDecimal price) {
        this.id = UUID.randomUUID();
        this.customerId = customerId;
        this.amount = amount;

        this.subscriptionStatus = subscriptionStatus;
        this.customerName = customerName;
        this.customerEmail = customerEmail;

        this.pricingPlanId = pricingPlanId;
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.pricingPlanName = pricingPlanName;
        this.price = price;
    }

    static Invoice createInvoice(UUID customerId, BigDecimal amount,
        String subscriptionStatus, String customerName, String customerEmail,
        UUID pricingPlanId, UUID productId, String productName, String productDescription, String pricingPlanName, BigDecimal price) {

        return new Invoice(customerId, amount,
                subscriptionStatus, customerName, customerEmail,
                pricingPlanId, productId, productName, productDescription, pricingPlanName, price);

    }

    InvoiceCreatedEvent createCustomerRegisteredEvent() {
        return new InvoiceCreatedEvent(this.getId(), this.getCustomerId(), this.getAmount());
    }

}