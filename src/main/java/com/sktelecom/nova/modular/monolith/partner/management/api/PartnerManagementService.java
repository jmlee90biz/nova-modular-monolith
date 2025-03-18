package com.sktelecom.nova.modular.monolith.partner.management.api;

import java.util.List;
import java.util.UUID;

public interface PartnerManagementService {
    PartnerDto registerPartner(PartnerRegistrationRequest partnerRegistrationRequest);
    PartnerDto getPartnerById(UUID partnerId);
    List<PartnerDto> findAllPartners();
}
