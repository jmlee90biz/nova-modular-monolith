package com.sktelecom.nova.modular.monolith.partner.settlement.internal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "partner_settlement", schema = "partner")
class PartnerSettlement {
    @Id
    private UUID id;

    private UUID partnerId;
    private double revenueShare;

    public PartnerSettlement(UUID partnerId, double revenueShare) {
        this.id = UUID.randomUUID();
        this.partnerId = partnerId;
        this.revenueShare = revenueShare;
    }

    static PartnerSettlement createPartner(UUID partnerId, double revenueShare) {

        return new PartnerSettlement(partnerId, revenueShare);
    }

//    PartnerRegisteredEvent createPartnerRegistereddEvent() {
//        return new PartnerRegisteredEvent(id, name, email);
//    }
}