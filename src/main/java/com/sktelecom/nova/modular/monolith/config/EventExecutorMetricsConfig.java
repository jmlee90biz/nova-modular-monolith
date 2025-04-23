package com.sktelecom.nova.modular.monolith.config;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.jvm.ExecutorServiceMetrics;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class EventExecutorMetricsConfig {

    @Bean(name = "taskExecutor")
    public Executor eventTaskExecutor(MeterRegistry registry) {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(12);
        executor.setMaxPoolSize(48);
        executor.setQueueCapacity(200);
        executor.setThreadNamePrefix("EventExecutor-");
//        executor.setCorePoolSize(12);
//        executor.setMaxPoolSize(64);
//        executor.setQueueCapacity(200);
//        executor.setThreadNamePrefix("EventExecutor-");

//        executor.setCorePoolSize(50);
//        executor.setMaxPoolSize(100);
//        executor.setQueueCapacity(100);
//        executor.setThreadNamePrefix("EventExecutor-");

//        executor.setCorePoolSize(200);
//        executor.setMaxPoolSize(400);
//        executor.setQueueCapacity(2000);
//        executor.setThreadNamePrefix("EventExecutor-");

        executor.initialize();

        // Micrometer Executor Metrics 등록
        return ExecutorServiceMetrics.monitor(registry, executor.getThreadPoolExecutor(), "event_task_executor");
    }
}

