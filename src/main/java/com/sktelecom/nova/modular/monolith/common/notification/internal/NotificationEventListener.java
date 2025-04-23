package com.sktelecom.nova.modular.monolith.common.notification.internal;

import com.sktelecom.nova.modular.monolith.common.notification.api.NotificationRequest;
import com.sktelecom.nova.modular.monolith.common.notification.api.NotificationService;
import com.sktelecom.nova.modular.monolith.common.notification.event.NotificationRequestedEvent;
import com.sktelecom.nova.modular.monolith.customer.profile.event.CustomerRegisteredEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import static org.springframework.transaction.event.TransactionPhase.*;

@Component
@RequiredArgsConstructor
public class NotificationEventListener {
    private final NotificationService notificationService;

    //@Async
    //@TransactionalEventListener(phase=AFTER_COMMIT)
    //@TransactionalEventListener(phase=BEFORE_COMMIT)
    //@TransactionalEventListener(phase=AFTER_COMPLETION)
    //@EventListener
    @ApplicationModuleListener
    void onCustomerRegisteredEvent(final CustomerRegisteredEvent customerRegisteredEvent) {
        notificationService.sendNotification(new NotificationRequest(
                customerRegisteredEvent.email(),
                "Customer Registered",
                "Succuess")
        );
    }


    //@Async("taskExecutor")
    //@ApplicationModuleListener
    //@EventListener
//    @TransactionalEventListener
//    void onNotificationRequestedEvent(final NotificationRequestedEvent notificationRequestedEvent) {
//        notificationService.sendNotification(NotificationRequestedEvent.fromEvent(notificationRequestedEvent));
//    }




}