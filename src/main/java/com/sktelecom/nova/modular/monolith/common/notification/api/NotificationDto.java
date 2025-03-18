package com.sktelecom.nova.modular.monolith.common.notification.api;

import java.util.UUID;

public record NotificationDto(UUID id, String recipient, String title, String message) {
}
