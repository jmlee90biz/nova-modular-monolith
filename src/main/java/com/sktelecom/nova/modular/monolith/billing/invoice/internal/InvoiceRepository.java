package com.sktelecom.nova.modular.monolith.billing.invoice.internal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
interface InvoiceRepository extends JpaRepository<Invoice, UUID> {
    Optional<Invoice> getInvoiceByCustomerId(UUID customerId);
}
