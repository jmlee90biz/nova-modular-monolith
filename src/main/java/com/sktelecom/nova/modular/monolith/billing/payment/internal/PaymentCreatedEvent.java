package com.sktelecom.nova.modular.monolith.billing.payment.internal;

import java.math.BigDecimal;
import java.util.UUID;

record PaymentCreatedEvent(UUID id, UUID invoiceId, BigDecimal amount) {
}
