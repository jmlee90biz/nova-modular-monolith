package com.sktelecom.nova.modular.monolith.common.notification.internal;

import com.sktelecom.nova.modular.monolith.common.notification.api.NotificationDto;

class NotificationMapper {
    static NotificationDto toNotificationDto(Notification notification) {
        return new NotificationDto(notification.getId(), notification.getRecipient(), notification.getTitle(), notification.getMessage());
    }
}
