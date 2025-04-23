package com.sktelecom.nova.modular.monolith.billing.payment.internal;

import com.sktelecom.nova.modular.monolith.billing.payment.event.PaymentCreatedEvent;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name = "payment", schema = "billing")
class Payment {
    @Id
    private UUID id;

    private UUID invoiceId;
    private BigDecimal amount;

    public Payment(UUID invoiceId, BigDecimal amount) {
        this.id = UUID.randomUUID();
        this.invoiceId = invoiceId;
        this.amount = amount;
    }

    static Payment createPayment(UUID invoiceId, BigDecimal amount) {
        return new Payment(invoiceId, amount);
    }

    PaymentCreatedEvent createPaymentCreatedEvent() {
        return new PaymentCreatedEvent(this.getId(), this.getInvoiceId(), this.getAmount());
    }

}