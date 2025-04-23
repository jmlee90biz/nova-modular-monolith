package com.sktelecom.nova.modular.monolith.partner.settlement.event;

import java.util.UUID;


public record PartnerSettlementCompletedEvent(UUID id, UUID partnerId, double revenue) {
}
