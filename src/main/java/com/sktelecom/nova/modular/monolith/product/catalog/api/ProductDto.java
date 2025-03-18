package com.sktelecom.nova.modular.monolith.product.catalog.api;

import java.util.UUID;

public record ProductDto(UUID id, String name, String description) {
}
