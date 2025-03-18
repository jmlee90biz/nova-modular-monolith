package com.sktelecom.nova.modular.monolith.common.notification.internal;

import com.sktelecom.nova.modular.monolith.common.notification.api.NotificationService;
import com.sktelecom.nova.modular.monolith.common.notification.event.NotificationRequestedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NotificationEventListener {
    private final NotificationService notificationService;

    @Async("taskExecutor")
    @ApplicationModuleListener
    //@EventListener
    void onNotificationRequestedEvent(final NotificationRequestedEvent notificationRequestedEvent) {
        notificationService.sendNotification(NotificationRequestedEvent.fromEvent(notificationRequestedEvent));
    }
}