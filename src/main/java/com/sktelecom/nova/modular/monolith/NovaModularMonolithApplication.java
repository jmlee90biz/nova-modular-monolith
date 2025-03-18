package com.sktelecom.nova.modular.monolith;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAspectJAutoProxy
public class NovaModularMonolithApplication {

    public static void main(String[] args) {
        SpringApplication.run(NovaModularMonolithApplication.class, args);
    }

}
