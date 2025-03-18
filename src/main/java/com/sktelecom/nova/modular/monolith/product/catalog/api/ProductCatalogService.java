package com.sktelecom.nova.modular.monolith.product.catalog.api;


import java.util.List;
import java.util.UUID;

public interface ProductCatalogService {
    ProductDto registerProduct(ProductRegistrationRequest productRegistrationRequest);
    ProductDto getProductById(UUID productId);
    List<ProductDto> findAllProducts();
}
