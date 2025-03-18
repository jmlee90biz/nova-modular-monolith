package com.sktelecom.nova.modular.monolith.billing.payment.api;


import java.util.List;
import java.util.UUID;

public interface PaymentService {
    PaymentDto createPayment(PaymentRequest paymentRequest);
    PaymentDto getPaymentById(UUID paymentId);
    List<PaymentDto> findAllPayments();
}
