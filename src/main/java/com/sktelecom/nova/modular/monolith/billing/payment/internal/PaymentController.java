package com.sktelecom.nova.modular.monolith.billing.payment.internal;

import com.sktelecom.nova.modular.monolith.billing.payment.api.PaymentDto;
import com.sktelecom.nova.modular.monolith.billing.payment.api.PaymentRequest;
import com.sktelecom.nova.modular.monolith.billing.payment.api.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/billing/payments")
class PaymentController {
    private final PaymentService paymentService;

    @GetMapping("/{id}")
    public PaymentDto getPaymentById(@PathVariable(name="id") UUID customerId) {
        return paymentService.getPaymentById(customerId);
    }

    @PostMapping
    public PaymentDto registerCustomer(PaymentRequest paymentRequest) {
        return paymentService.createPayment(paymentRequest);
    }

    @GetMapping
    public List<PaymentDto> getAllCustomers() {
        return paymentService.findAllPayments();
    }


}
