package com.sktelecom.nova.modular.monolith.customer.profile.event;

import java.util.UUID;

public record CustomerRegisteredEvent(UUID id, String name, String email) {
}
