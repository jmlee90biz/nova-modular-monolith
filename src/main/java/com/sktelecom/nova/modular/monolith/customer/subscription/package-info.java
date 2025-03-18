@ApplicationModule(
        displayName = "customer-subscription",
        allowedDependencies = {
                "customer.profile::api",
                "product.pricing::api",
                "common.notification::event"
        }
)
package com.sktelecom.nova.modular.monolith.customer.subscription;

import org.springframework.modulith.ApplicationModule;