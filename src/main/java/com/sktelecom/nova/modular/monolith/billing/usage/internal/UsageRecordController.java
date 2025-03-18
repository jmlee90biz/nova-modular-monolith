package com.sktelecom.nova.modular.monolith.billing.usage.internal;

import com.sktelecom.nova.modular.monolith.billing.usage.api.UsageRecordCreationRequest;
import com.sktelecom.nova.modular.monolith.billing.usage.api.UsageRecordDto;
import com.sktelecom.nova.modular.monolith.billing.usage.api.UsageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/billing/usageRecords")
class UsageRecordController {
    private final UsageService usageService;

    @GetMapping("/{id}")
    public UsageRecordDto getUsageRecordById(@PathVariable(name="id") UUID partnerId) {
        return usageService.getUsageRecordById(partnerId);
    }

    @PostMapping
    public UsageRecordDto createU(UsageRecordCreationRequest usageRecordCreateionRequest) {
        return usageService.createUsageRecord(usageRecordCreateionRequest);
    }

    @GetMapping
    public List<UsageRecordDto> getAllPartners() {
        return usageService.findAllUsageRecords();
    }


}
