package com.sktelecom.nova.modular.monolith.billing.invoice.internal;

import com.sktelecom.nova.modular.monolith.billing.invoice.api.InvoiceCreationRequest;
import com.sktelecom.nova.modular.monolith.billing.invoice.api.InvoiceDto;
import com.sktelecom.nova.modular.monolith.billing.invoice.api.InvoiceService;


import com.sktelecom.nova.modular.monolith.shared.kernel.EventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {
    private final InvoiceRepository invoiceRepository;
    private final EventPublisher eventPublisher;

    @Transactional
    @Override
    public InvoiceDto createInvoice(InvoiceCreationRequest invoiceCreationRequest) {
        Optional<Invoice> registeredInvoice = invoiceRepository.getInvoiceByCustomerId(invoiceCreationRequest.subscriptionActivatedEvent().customerId());

        /*
        if (registeredInvoice.isPresent()) {
            // Update 로직
            Invoice invoiceToUpdate = registeredInvoice.get();
            if(!invoiceToUpdate.getSubscriptionStatus().equals(SubscriptionStatus.CANCELED)) {
                //if(invoiceCreationOrUpdate)
            }
            return InvoiceMapper.toInvoiceDto(invoiceToUpdate);
//            invoiceToUpdate.updateFields(invoiceCreationOrUpdateRequest); // 필요한 필드 업데이트 메서드
//            invoiceRepository.save(invoiceToUpdate);
        } else {
            */
            // Insert 로직
            Invoice registeredCustomer = invoiceRepository.save(
                    Invoice.createInvoice(
                            invoiceCreationRequest.subscriptionActivatedEvent().customerId(),
                            BigDecimal.ZERO,
                            invoiceCreationRequest.subscriptionActivatedEvent().subscriptionStatus(),
                            invoiceCreationRequest.subscriptionActivatedEvent().customerName(),
                            invoiceCreationRequest.subscriptionActivatedEvent().customerEmail(),
                            invoiceCreationRequest.subscriptionActivatedEvent().pricingPlanId(),
                            invoiceCreationRequest.subscriptionActivatedEvent().productId(),
                            invoiceCreationRequest.subscriptionActivatedEvent().productName(),
                            invoiceCreationRequest.subscriptionActivatedEvent().productDescription(),
                            invoiceCreationRequest.subscriptionActivatedEvent().pricingPlanName(),
                            invoiceCreationRequest.subscriptionActivatedEvent().price()
                    )
            );
            return InvoiceMapper.toInvoiceDto(registeredCustomer);
       // }
    }

    @Override
    public InvoiceDto getInvoiceById(UUID invoiceId) {
        return invoiceRepository.findById(invoiceId).map(InvoiceMapper::toInvoiceDto)
                .orElseThrow(()->new RuntimeException("Customer not found"));
    }

    @Override
    public List<InvoiceDto> findAllInvoices() {
        return invoiceRepository.findAll().stream().map(InvoiceMapper::toInvoiceDto).toList();
    }
}
