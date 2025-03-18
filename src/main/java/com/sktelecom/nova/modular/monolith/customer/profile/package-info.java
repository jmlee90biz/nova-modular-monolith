@ApplicationModule(
        displayName = "customer-profile",
        allowedDependencies = {
                "common.notification::event"
        }
)
package com.sktelecom.nova.modular.monolith.customer.profile;

import org.springframework.modulith.ApplicationModule;