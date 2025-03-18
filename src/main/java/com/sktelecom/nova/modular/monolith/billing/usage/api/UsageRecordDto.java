package com.sktelecom.nova.modular.monolith.billing.usage.api;

import java.math.BigDecimal;
import java.util.UUID;

public record UsageRecordDto(UUID id, UUID customerId, UUID productId, int usage) {
}
