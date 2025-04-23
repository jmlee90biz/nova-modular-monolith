@ApplicationModule(
        displayName = "billing-invoice",
        allowedDependencies = {
                "customer.subscription::event",
                "billing.usage::event",
                "common.notification::event"
        }
)
package com.sktelecom.nova.modular.monolith.billing.invoice;

import org.springframework.modulith.ApplicationModule;