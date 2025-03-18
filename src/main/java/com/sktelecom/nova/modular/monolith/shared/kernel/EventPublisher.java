package com.sktelecom.nova.modular.monolith.shared.kernel;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class EventPublisher {
    private final ApplicationEventPublisher eventPublisher;

    @Transactional
    public void publish(Object object) {
        eventPublisher.publishEvent(object);
    }
}
