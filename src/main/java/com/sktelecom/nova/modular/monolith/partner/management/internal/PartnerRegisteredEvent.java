package com.sktelecom.nova.modular.monolith.partner.management.internal;

import java.util.UUID;

record PartnerRegisteredEvent(UUID id, String name, String description) {
}
