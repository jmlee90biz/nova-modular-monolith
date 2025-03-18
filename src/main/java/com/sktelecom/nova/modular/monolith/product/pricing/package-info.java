@ApplicationModule(
        displayName = "product-pricing",
        allowedDependencies = {
                "product.catalog::api"
        }
)
package com.sktelecom.nova.modular.monolith.product.pricing;

import org.springframework.modulith.ApplicationModule;