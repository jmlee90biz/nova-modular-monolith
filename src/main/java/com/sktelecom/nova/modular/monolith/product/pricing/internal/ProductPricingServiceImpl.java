package com.sktelecom.nova.modular.monolith.product.pricing.internal;

import com.sktelecom.nova.modular.monolith.product.catalog.api.ProductCatalogService;
import com.sktelecom.nova.modular.monolith.product.catalog.api.ProductDto;
import com.sktelecom.nova.modular.monolith.product.pricing.api.PricingPlanRegistrationRequest;
import com.sktelecom.nova.modular.monolith.product.pricing.api.PricingPlanDto;
import com.sktelecom.nova.modular.monolith.product.pricing.api.ProductPricingPlanDto;
import com.sktelecom.nova.modular.monolith.product.pricing.api.ProductPricingService;
import com.sktelecom.nova.modular.monolith.shared.kernel.EventPublisher;
import com.sktelecom.nova.modular.monolith.shared.util.JoinUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
class ProductPricingServiceImpl implements ProductPricingService {
    private final PricingPlanRepository pricingPlanRepository;

    private final ProductCatalogService productCatalogService;

    private final EventPublisher eventPublisher;

    public ProductPricingPlanDto findProductPricingPlanById(UUID pricingPlanId) {
        PricingPlanDto pricingPlanDto = getPricingPlanById(pricingPlanId);
        ProductDto productDto = productCatalogService.getProductById(pricingPlanDto.productId());
        return ProductPricingPlanDto.join(productDto, pricingPlanDto);
    }


    @Override
    @Transactional
    public PricingPlanDto registerPricingPlan(PricingPlanRegistrationRequest pricingPlanRegistrationRequest) {
        PricingPlan registeredPricingPlan = pricingPlanRepository.save(
                PricingPlan.createPricingPlan(
                        pricingPlanRegistrationRequest.productId(),
                        pricingPlanRegistrationRequest.name(),
                        pricingPlanRegistrationRequest.price())
        );

        eventPublisher.publish(registeredPricingPlan.createPricingPlanRegisteredEvent());

        return PricingPlanMapper.toPricingPlanDto(registeredPricingPlan);
    }

    @Override
    public PricingPlanDto getPricingPlanById(UUID pricingPlanId) {
        return pricingPlanRepository.findById(pricingPlanId).map(PricingPlanMapper::toPricingPlanDto)
                .orElseThrow(()->new RuntimeException("PricingPlan not found"));
    }

    @Override
    public List<PricingPlanDto> findAllPricingPlans() {
        return pricingPlanRepository.findAll().stream().map(PricingPlanMapper::toPricingPlanDto).toList();
    }

    @Override
    public List<ProductPricingPlanDto> findAllProductPricingPlans() {
        return JoinUtil.<UUID, ProductDto, PricingPlanDto, ProductPricingPlanDto>joinLists(
                productCatalogService.findAllProducts(), ProductDto::id,
                findAllPricingPlans(), PricingPlanDto::productId,
                ProductPricingPlanDto::join
        );
    }


}
