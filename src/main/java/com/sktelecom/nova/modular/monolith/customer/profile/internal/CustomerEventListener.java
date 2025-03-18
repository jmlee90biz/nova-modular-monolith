package com.sktelecom.nova.modular.monolith.customer.profile.internal;

import com.sktelecom.nova.modular.monolith.common.notification.event.NotificationRequestedEvent;
import com.sktelecom.nova.modular.monolith.customer.profile.event.CustomerRegisteredEvent;
import com.sktelecom.nova.modular.monolith.shared.kernel.EventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerEventListener {
    private final EventPublisher eventPublisher;

    @Async("taskExecutor")
    @ApplicationModuleListener
    //@EventListener
    void onCustomerRegisteredEvent(final CustomerRegisteredEvent customerRegisteredEvent) {
        eventPublisher.publish(
                NotificationRequestedEvent.create(
                        customerRegisteredEvent.email(),
                        "Customer Registered",
                        "Welcome!"
                )
        );
    }
}
