package com.sktelecom.nova.modular.monolith.billing.usage.internal;

import com.sktelecom.nova.modular.monolith.billing.usage.api.UsageRecordDto;

class UsageRecordMapper {
    static UsageRecordDto toUsageRecordDto(UsageRecord usageRecord) {
        return new UsageRecordDto(usageRecord.getId(), usageRecord.getCustomerId(), usageRecord.getProductId(), usageRecord.getUsage());
    }
}
