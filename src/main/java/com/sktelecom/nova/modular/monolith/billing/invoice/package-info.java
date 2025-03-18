@ApplicationModule(
        displayName = "billing-invoice",
        allowedDependencies = {
                "customer.subscription::event"
        }
)
package com.sktelecom.nova.modular.monolith.billing.invoice;

import org.springframework.modulith.ApplicationModule;