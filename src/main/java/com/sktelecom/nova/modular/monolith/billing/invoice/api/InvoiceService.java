package com.sktelecom.nova.modular.monolith.billing.invoice.api;


import java.util.List;
import java.util.UUID;

public interface InvoiceService {
    InvoiceDto createInvoice(InvoiceCreationRequest invoiceCreationRequest);
    InvoiceDto getInvoiceById(UUID customerId);
    List<InvoiceDto> findAllInvoices();
}
