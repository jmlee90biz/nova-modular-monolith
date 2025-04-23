package com.sktelecom.nova.modular.monolith.billing.usage.internal;

import com.sktelecom.nova.modular.monolith.billing.usage.event.UsageRecordCreatedEvent;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "usage_record", schema = "billing")
class UsageRecord {
    @Id
    private UUID id;

    private UUID customerId;
    private UUID productId;
    private int usage;

    public UsageRecord(UUID customerId, UUID productId, int usage) {
        this.id = UUID.randomUUID();
        this.customerId = customerId;
        this.productId = productId;
        this.usage = usage;
    }

    static UsageRecord createUsageRecord(UUID customerId, UUID productId, int usage) {
        return new UsageRecord(customerId, productId, usage);
    }

    UsageRecordCreatedEvent createUsageRecordCreatedEvent() {
        return new UsageRecordCreatedEvent(id, customerId, productId, usage);
    }
}