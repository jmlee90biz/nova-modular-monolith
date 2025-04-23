package com.sktelecom.nova.modular.monolith.partner.settlement.internal;

import com.sktelecom.nova.modular.monolith.partner.management.api.PartnerDto;
import com.sktelecom.nova.modular.monolith.partner.management.api.PartnerManagementService;
import com.sktelecom.nova.modular.monolith.partner.management.api.PartnerRegistrationRequest;
import com.sktelecom.nova.modular.monolith.partner.settlement.api.PartnerSettlementService;
import com.sktelecom.nova.modular.monolith.shared.kernel.EventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
class PartnerSettlementServiceImpl implements PartnerSettlementService {
    private final PartnerSettlementRepository partnerSettlementRepository;
    private final EventPublisher eventPublisher;

    @Override
    public void settlePartnerRevenue(UUID partnerId, double revenue) {

    }
//
//    @Override
//    @Transactional
//    public PartnerDto registerPartner(PartnerRegistrationRequest partnerRegistrationRequest) {
//        PartnerSettlement registeredPartner = partnerSettlementRepository.save(
//                PartnerSettlement.createPartner(partnerRegistrationRequest.name(), partnerRegistrationRequest.email())
//        );
//
//        eventPublisher.publish(registeredPartner.createPartnerRegistereddEvent());
//
//        return PartnerMapper.toPartnerDto(registeredPartner);
//    }
//
//    @Override
//    public PartnerDto getPartnerById(UUID partnerId) {
//        return partnerRepository.findById(partnerId).map(PartnerMapper::toPartnerDto)
//                .orElseThrow(()->new RuntimeException("Partner not found"));
//    }
//
//    @Override
//    public List<PartnerDto> findAllPartners() {
//        return partnerRepository.findAll().stream().map(PartnerMapper::toPartnerDto).toList();
//    }
}
