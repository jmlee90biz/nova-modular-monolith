package com.sktelecom.nova.modular.monolith.common.notification.api;

import com.sktelecom.nova.modular.monolith.common.notification.event.NotificationRequestedEvent;

public record NotificationRequest(String recipient, String title, String message) {
    public static NotificationRequest fromEvent(NotificationRequestedEvent event) {
        return new NotificationRequest(
                event.recipient(),
                event.title(),
                event.message()
        );
    }
}
