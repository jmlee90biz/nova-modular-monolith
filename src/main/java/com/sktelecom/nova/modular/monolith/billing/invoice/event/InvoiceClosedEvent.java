package com.sktelecom.nova.modular.monolith.billing.invoice.event;

import java.math.BigDecimal;
import java.util.UUID;

public record InvoiceClosedEvent(UUID id, UUID customerId, BigDecimal amount) {
}
