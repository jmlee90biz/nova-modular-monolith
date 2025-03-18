package com.sktelecom.nova.modular.monolith.product.pricing.internal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
interface PricingPlanRepository extends JpaRepository<PricingPlan, UUID> {
    List<PricingPlan> findAllPricingPlanByProductId(UUID productId);
}
