package com.sktelecom.nova.modular.monolith.billing.usage.internal;

import java.util.UUID;

record UsageRecordCreatedEvent(UUID id, UUID customerId, UUID productId, int usage) {
}
