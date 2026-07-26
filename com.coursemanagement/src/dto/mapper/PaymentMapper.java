package dto.mapper;

import dto.request.*;
import dto.response.*;
import model.Payment;

public class PaymentMapper {

    public Payment toEntity(CreatePaymentRequest request) {
        return new Payment(request.getEnrollmentId(), request.getAmount(), request.getPaymentMethod());

    }

    public PaymentResponse toResponse(Payment payment) {
        return new PaymentResponse(payment.getId(), payment.getAmount(), payment.getPaymentMethod(), payment.getPaymentStatus(), payment.getTransactionReference());

    }

}