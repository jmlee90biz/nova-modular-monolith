package com.sktelecom.nova.modular.monolith.partner.settlement.api;

import java.util.List;
import java.util.UUID;

public interface PartnerSettlementService {
    void settlePartnerRevenue(UUID partnerId, double revenue);
}
