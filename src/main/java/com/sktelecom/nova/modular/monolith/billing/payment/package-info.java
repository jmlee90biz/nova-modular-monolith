@ApplicationModule(
        displayName = "billing-payment",
        allowedDependencies = {
            "billing.invoice::event",
        "common.notification::event"
        }
)
package com.sktelecom.nova.modular.monolith.billing.payment;

import org.springframework.modulith.ApplicationModule;