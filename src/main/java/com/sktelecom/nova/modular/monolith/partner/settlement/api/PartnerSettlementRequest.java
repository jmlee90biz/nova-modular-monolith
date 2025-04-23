package com.sktelecom.nova.modular.monolith.partner.settlement.api;

import java.util.UUID;

public record PartnerSettlementRequest(UUID partnerId, double revenue) {
}