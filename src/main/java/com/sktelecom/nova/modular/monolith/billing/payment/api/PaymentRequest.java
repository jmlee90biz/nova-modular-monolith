package com.sktelecom.nova.modular.monolith.billing.payment.api;

import java.math.BigDecimal;
import java.util.UUID;

public record PaymentRequest(UUID invoiceId, BigDecimal amount) {
}