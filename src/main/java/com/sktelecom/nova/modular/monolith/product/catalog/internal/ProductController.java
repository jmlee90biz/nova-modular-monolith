package com.sktelecom.nova.modular.monolith.product.catalog.internal;

import com.sktelecom.nova.modular.monolith.product.catalog.api.ProductCatalogService;
import com.sktelecom.nova.modular.monolith.product.catalog.api.ProductDto;
import com.sktelecom.nova.modular.monolith.product.catalog.api.ProductRegistrationRequest;
import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/product/catalog/products")
@Tag(name="product-catalog")
class ProductController {
    private final ProductCatalogService productCatalogService;

    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable(name="id") UUID productId) {
        return productCatalogService.getProductById(productId);
    }

    @PostMapping
    public ProductDto registerProduct(@RequestBody ProductRegistrationRequest productRegistrationRequest) {
        return productCatalogService.registerProduct(productRegistrationRequest);
    }

    @GetMapping
    public List<ProductDto> getAllProducts() {
        return productCatalogService.findAllProducts();
    }
}
