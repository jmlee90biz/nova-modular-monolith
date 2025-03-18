package com.sktelecom.nova.modular.monolith.partner.management.internal;

import com.sktelecom.nova.modular.monolith.partner.management.api.PartnerManagementService;
import com.sktelecom.nova.modular.monolith.partner.management.api.PartnerRegistrationRequest;
import com.sktelecom.nova.modular.monolith.partner.management.api.PartnerDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/partner/management/partners")
@Tag(name="partner-management")
class PartnerController {
    private final PartnerManagementService partnerManagementService;

    @GetMapping("/{id}")
    public PartnerDto getPartnerById(@PathVariable(name="id") UUID partnerId) {
        return partnerManagementService.getPartnerById(partnerId);
    }

    @PostMapping
    public PartnerDto registerPartner(@RequestBody PartnerRegistrationRequest partnerRegistrationRequest) {
        return partnerManagementService.registerPartner(partnerRegistrationRequest);
    }

    @GetMapping
    public List<PartnerDto> getAllPartners() {
        return partnerManagementService.findAllPartners();
    }


}
