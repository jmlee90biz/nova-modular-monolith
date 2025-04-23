package com.sktelecom.nova.modular.monolith.partner.settlement.api;

import java.math.BigDecimal;
import java.util.UUID;


public record PartnerSettlementDto(UUID id, UUID partnerId, double revenue) {
}
