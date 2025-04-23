package com.sktelecom.nova.modular.monolith.common.notification.internal;

import com.sktelecom.nova.modular.monolith.common.notification.api.NotificationDto;
import com.sktelecom.nova.modular.monolith.common.notification.api.NotificationRequest;
import com.sktelecom.nova.modular.monolith.common.notification.api.NotificationService;

import com.sktelecom.nova.modular.monolith.shared.kernel.EventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
class NotificationServiceImpl implements NotificationService {
    private final NotificationRepository notificationRepository;
    private final EventPublisher eventPublisher;

    @Override
    @Transactional
    public NotificationDto sendNotification(NotificationRequest notificationRequest) {
        Notification createdNotification = notificationRepository.save(
                Notification.createNotification(
                        notificationRequest.recipient(),
                        notificationRequest.title(),
                        notificationRequest.message()
                )
        );

        System.out.println("Notification Send: " + createdNotification);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        eventPublisher.publish(createdNotification.createNotificationSentEvent());

        return NotificationMapper.toNotificationDto(createdNotification);
    }

    @Override
    public NotificationDto getNotificationById(UUID customerId) {
        return notificationRepository.findById(customerId).map(NotificationMapper::toNotificationDto)
                .orElseThrow(()->new RuntimeException("Notification not found"));
    }

    @Override
    public List<NotificationDto> findAllNotifications() {
        return notificationRepository.findAll().stream().map(NotificationMapper::toNotificationDto).toList();
    }
}
