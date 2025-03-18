package com.sktelecom.nova.modular.monolith.product.catalog.internal;

import com.sktelecom.nova.modular.monolith.product.catalog.api.ProductDto;

class ProductMapper {
    static ProductDto toProductDto(Product product) {
        return new ProductDto(product.getId(), product.getName(), product.getDescription());
    }
}
