package com.sktelecom.nova.modular.monolith.common.notification.api;

import java.util.List;
import java.util.UUID;

public interface NotificationService {
    NotificationDto sendNotification(NotificationRequest notificationRequest);
    NotificationDto getNotificationById(UUID customerId);
    List<NotificationDto> findAllNotifications();
}
