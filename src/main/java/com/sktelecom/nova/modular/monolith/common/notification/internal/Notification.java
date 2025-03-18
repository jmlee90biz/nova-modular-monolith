package com.sktelecom.nova.modular.monolith.common.notification.internal;

import com.sktelecom.nova.modular.monolith.common.notification.event.NotificationSentEvent;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "notification", schema = "common")
class Notification {
    @Id
    private UUID id;

    private String recipient;
    private String title;
    private String message;

    public Notification(String recipient, String title, String message) {
        this.id = UUID.randomUUID();
        this.recipient = recipient;
        this.title = title;
        this.message = message;
    }

    public static Notification createNotification(String recipient, String title, String message) {
        return new Notification(recipient, title, message);
    }

    public NotificationSentEvent createNotificationSentEvent() {
        return new NotificationSentEvent(this.id, this.recipient, this.title, this.message);
    }
}

