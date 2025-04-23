package com.sktelecom.nova.modular.monolith.billing.payment.event;

import java.math.BigDecimal;
import java.util.UUID;

public record PaymentCreatedEvent(UUID id, UUID invoiceId, BigDecimal amount) {
}
