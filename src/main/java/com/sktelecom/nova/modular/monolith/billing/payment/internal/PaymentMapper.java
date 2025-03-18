package com.sktelecom.nova.modular.monolith.billing.payment.internal;

import com.sktelecom.nova.modular.monolith.billing.payment.api.PaymentDto;

class PaymentMapper {
    static PaymentDto toPaymentDto(Payment payment) {
        return new PaymentDto(payment.getId(), payment.getInvoiceId(), payment.getAmount());
    }
}
