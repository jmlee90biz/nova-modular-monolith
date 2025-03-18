package com.sktelecom.nova.modular.monolith.product.pricing.api;


import com.sktelecom.nova.modular.monolith.product.pricing.event.PricingPlanRegistrationRequest;

import java.util.List;
import java.util.UUID;

public interface ProductPricingService {
    PricingPlanDto registerPricingPlan(PricingPlanRegistrationRequest pricingPlanRegistrationRequest);
    PricingPlanDto getPricingPlanById(UUID pricingPlanId);
    List<PricingPlanDto> findAllPricingPlans();

    List<ProductPricingPlanDto> findAllProductPricingPlans();
    ProductPricingPlanDto findProductPricingPlanById(UUID pricingPlanId);
}
