package com.sktelecom.nova.modular.monolith.partner.management.internal;

import com.sktelecom.nova.modular.monolith.partner.management.api.PartnerDto;

class PartnerMapper {
    static PartnerDto toPartnerDto(Partner partner) {
        return new PartnerDto(partner.getId(), partner.getName(), partner.getEmail());
    }
}
