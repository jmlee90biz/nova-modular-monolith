package com.sktelecom.nova.modular.monolith.product.pricing.internal;

import com.sktelecom.nova.modular.monolith.product.pricing.api.PricingPlanRegistrationRequest;
import com.sktelecom.nova.modular.monolith.product.pricing.api.PricingPlanDto;
import com.sktelecom.nova.modular.monolith.product.pricing.api.ProductPricingPlanDto;
import com.sktelecom.nova.modular.monolith.product.pricing.api.ProductPricingService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/product/pricing")
@Tag(name="product-pricing")
class PricingPlanController {
    private final ProductPricingService productPricingService;

    @GetMapping("/pricing-plans/{id}")
    public PricingPlanDto getPricingPlanById(@PathVariable(name="id") UUID pricingPlanId) {
        return productPricingService.getPricingPlanById(pricingPlanId);
    }

    @PostMapping("/pricing-plans")
    public PricingPlanDto registerPricingPlan(@RequestBody PricingPlanRegistrationRequest pricingPlanRegistrationRequest) {
        return productPricingService.registerPricingPlan(pricingPlanRegistrationRequest);
    }

    @GetMapping("/pricing-plans")
    public List<PricingPlanDto> getAllPricingPlans() {
        return productPricingService.findAllPricingPlans();
    }

    @GetMapping("/product-pricing-plans")
    public List<ProductPricingPlanDto> getAllProductPricingPlans() {
        return productPricingService.findAllProductPricingPlans();
    }




}
