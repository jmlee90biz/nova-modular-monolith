package com.sktelecom.nova.modular.monolith.customer.profile.internal;

import com.sktelecom.nova.modular.monolith.common.notification.event.NotificationRequestedEvent;
import com.sktelecom.nova.modular.monolith.customer.profile.event.CustomerRegisteredEvent;
import com.sktelecom.nova.modular.monolith.shared.kernel.EventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@RequiredArgsConstructor
public class CustomerEventListener {
    //private final EventPublisher eventPublisher;
    private final ApplicationEventPublisher eventPublisher;

    //@Async("taskExecutor")
//    @ApplicationModuleListener
//    //@EventListener
//    @Transactional(propagation = Propagation.REQUIRES_NEW)
//    @TransactionalEventListener
    void onCustomerRegisteredEvent(final CustomerRegisteredEvent customerRegisteredEvent) {
        eventPublisher.publishEvent(
                NotificationRequestedEvent.create(
                        customerRegisteredEvent.email(),
                        "Customer Registered",
                        "Welcome!"
                )
        );
    }
}
