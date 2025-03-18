package com.sktelecom.nova.modular.monolith.common.notification.internal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
interface NotificationRepository extends JpaRepository<Notification, UUID> {
}
