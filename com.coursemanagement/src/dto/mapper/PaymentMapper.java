package dto.mapper;

import dto.request.*;
import dto.response.*;
import model.Enrollment;
import model.Payment;

import java.util.ArrayList;
import java.util.List;

public class PaymentMapper {

    public Payment toEntity(CreatePaymentRequest request) {
        return new Payment(request.getEnrollmentId(), request.getAmount(), request.getPaymentMethod());

    }

    public PaymentResponse toResponse(Payment payment) {
        return new PaymentResponse(payment.getId(), payment.getAmount(), payment.getPaymentMethod(), payment.getPaymentStatus(), payment.getTransactionReference());

    }

    public List<PaymentResponse> toResponse(List<Payment> payments) {
        List<PaymentResponse> responses = new ArrayList<>();

        for (Payment payment : payments) {
            responses.add(toResponse(payment));
        }

        return responses;
    }

}