package com.sktelecom.nova.modular.monolith.billing.usage.internal;

import com.sktelecom.nova.modular.monolith.billing.usage.api.UsageRecordDto;
import com.sktelecom.nova.modular.monolith.billing.usage.api.UsageRecordCreationRequest;
import com.sktelecom.nova.modular.monolith.billing.usage.api.UsageService;

import com.sktelecom.nova.modular.monolith.shared.kernel.EventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
class UsagetServiceImpl implements UsageService {
    private final UsageRecordRepository usageRecordRepository;
    private final EventPublisher eventPublisher;

    @Transactional
    @Override
    public UsageRecordDto createUsageRecord(UsageRecordCreationRequest usageRecordCreationRequest) {
        UsageRecord registeredPartner = usageRecordRepository.save(
                UsageRecord.createUsageRecord(usageRecordCreationRequest.customerId(), usageRecordCreationRequest.productId(), usageRecordCreationRequest.usage())
        );

        eventPublisher.publish(registeredPartner.createUsageRecordCreatedEvent());

        return UsageRecordMapper.toUsageRecordDto(registeredPartner);
    }

    @Override
    public UsageRecordDto getUsageRecordById(UUID usageRecordId) {
        return usageRecordRepository.findById(usageRecordId).map(UsageRecordMapper::toUsageRecordDto)
                .orElseThrow(()->new RuntimeException("Partner not found"));
    }

    @Override
    public List<UsageRecordDto> findAllUsageRecords() {
        return usageRecordRepository.findAll().stream().map(UsageRecordMapper::toUsageRecordDto).toList();
    }
}
