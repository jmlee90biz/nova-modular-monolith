package com.sktelecom.nova.modular.monolith.common.notification.event;

import com.sktelecom.nova.modular.monolith.common.notification.api.NotificationRequest;

public record NotificationRequestedEvent(String recipient, String title, String message) {
    public static NotificationRequestedEvent create(String recipient, String title, String message) {
        return new NotificationRequestedEvent(recipient, title, message);
    }

    public static NotificationRequest fromEvent(NotificationRequestedEvent event) {
        return new NotificationRequest(
                event.recipient(),
                event.title(),
                event.message()
        );
    }
}
