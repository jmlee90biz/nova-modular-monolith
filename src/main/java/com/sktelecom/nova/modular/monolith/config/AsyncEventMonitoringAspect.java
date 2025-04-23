package com.sktelecom.nova.modular.monolith.config;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.ApplicationEvent;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

//@Aspect
//@Component
public class AsyncEventMonitoringAspect {

    private final MeterRegistry meterRegistry;

    public AsyncEventMonitoringAspect(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    @Around("@annotation(ApplicationModuleListener) && args(event)")
    public Object monitorAsyncEvent(ProceedingJoinPoint joinPoint, Object event) throws Throwable {
        if (event instanceof ApplicationEvent appEvent) {
            String eventName = appEvent.getClass().getSimpleName();
            Instant start = Instant.now();

            // 이벤트 소비 횟수 증가
            meterRegistry.counter("modulith.events.async.consumed", "event", eventName).increment();

            Object result = joinPoint.proceed(); // 실제 이벤트 실행

            // 이벤트 실행 시간 측정
            Duration duration = Duration.between(start, Instant.now());
            meterRegistry.timer("modulith.events.async.duration", "event", eventName).record(duration);

            return result;
        }

        return joinPoint.proceed();
    }
}
