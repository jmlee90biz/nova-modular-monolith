package com.sktelecom.nova.modular.monolith.billing.usage.event;

import java.util.UUID;

public record UsageRecordCreatedEvent(UUID id, UUID customerId, UUID productId, int usage) {
}
