package com.sktelecom.nova.modular.monolith.common.notification.event;

import java.util.UUID;

public record NotificationSentEvent(UUID id, String recipient, String title, String message) {
}
