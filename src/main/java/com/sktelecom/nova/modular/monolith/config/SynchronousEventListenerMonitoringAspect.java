package com.sktelecom.nova.modular.monolith.config;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

@Aspect
@Component
public class SynchronousEventListenerMonitoringAspect {

    private final MeterRegistry meterRegistry;

    public SynchronousEventListenerMonitoringAspect(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    @Around("@annotation(applicationModuleListener)")
    public Object monitorSynchronousEventListener(ProceedingJoinPoint joinPoint, ApplicationModuleListener applicationModuleListener) throws Throwable {
        String eventName = joinPoint.getSignature().getName();
        Instant start = Instant.now();

        // 이벤트 리스너 실행 횟수 증가
        meterRegistry.counter("modulith.events.synchronous.consumed", "event", eventName).increment();

        Object result = joinPoint.proceed(); // 실제 이벤트 소비 실행

        // 이벤트 리스너 실행 시간 측정
        Duration duration = Duration.between(start, Instant.now());
        meterRegistry.timer("modulith.events.synchronous.consume.duration", "event", eventName).record(duration);

        return result;
    }
}
