package com.sktelecom.nova.modular.monolith.customer.profile.api;

import java.util.UUID;

public record CustomerDto(UUID id, String name, String email) {
}
