@ApplicationModule(
        displayName="partner-settlement",
        allowedDependencies = {
            "billing.payment::event",
            "partner.management::api",
        "common.notification::event"
        }
)
package com.sktelecom.nova.modular.monolith.partner.settlement;

import org.springframework.modulith.ApplicationModule;
