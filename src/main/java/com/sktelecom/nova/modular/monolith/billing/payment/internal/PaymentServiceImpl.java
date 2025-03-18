package com.sktelecom.nova.modular.monolith.billing.payment.internal;

import com.sktelecom.nova.modular.monolith.billing.payment.api.PaymentDto;
import com.sktelecom.nova.modular.monolith.billing.payment.api.PaymentRequest;
import com.sktelecom.nova.modular.monolith.billing.payment.api.PaymentService;

import com.sktelecom.nova.modular.monolith.shared.kernel.EventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;
    private final EventPublisher eventPublisher;

    @Override
    public PaymentDto createPayment(PaymentRequest paymentRequest) {
        Payment createdPayment = paymentRepository.save(
                Payment.createPayment(paymentRequest.invoiceId(), paymentRequest.amount())
        );

        eventPublisher.publish(createdPayment.createPaymentCreatedEvent());

        return PaymentMapper.toPaymentDto(createdPayment);
    }

    @Override
    public PaymentDto getPaymentById(UUID paymentId) {
        return paymentRepository.findById(paymentId).map(PaymentMapper::toPaymentDto)
                .orElseThrow(()->new RuntimeException("Payment not found"));
    }

    @Override
    public List<PaymentDto> findAllPayments() {
        return paymentRepository.findAll().stream().map(PaymentMapper::toPaymentDto).toList();
    }
}
