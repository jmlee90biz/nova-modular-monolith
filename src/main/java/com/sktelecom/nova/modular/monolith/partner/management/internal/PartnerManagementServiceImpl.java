package com.sktelecom.nova.modular.monolith.partner.management.internal;

import com.sktelecom.nova.modular.monolith.partner.management.api.PartnerManagementService;
import com.sktelecom.nova.modular.monolith.partner.management.api.PartnerRegistrationRequest;
import com.sktelecom.nova.modular.monolith.partner.management.api.PartnerDto;

import com.sktelecom.nova.modular.monolith.shared.kernel.EventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
class PartnerManagementServiceImpl implements PartnerManagementService {
    private final PartnerRepository partnerRepository;
    private final EventPublisher eventPublisher;

    @Override
    @Transactional
    public PartnerDto registerPartner(PartnerRegistrationRequest partnerRegistrationRequest) {
        Partner registeredPartner = partnerRepository.save(
                Partner.createPartner(partnerRegistrationRequest.name(), partnerRegistrationRequest.email())
        );

        eventPublisher.publish(registeredPartner.createPartnerRegistereddEvent());

        return PartnerMapper.toPartnerDto(registeredPartner);
    }

    @Override
    public PartnerDto getPartnerById(UUID partnerId) {
        return partnerRepository.findById(partnerId).map(PartnerMapper::toPartnerDto)
                .orElseThrow(()->new RuntimeException("Partner not found"));
    }

    @Override
    public List<PartnerDto> findAllPartners() {
        return partnerRepository.findAll().stream().map(PartnerMapper::toPartnerDto).toList();
    }
}
