package service;


import dto.mapper.PaymentMapper;
import dto.request.CreatePaymentRequest;
import dto.response.PaymentResponse;
import model.Payment;
import model.PaymentMethod;
import repository.InMemoryPaymentRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class PaymentService {
    public InMemoryPaymentRepository paymentRepository;

    public PaymentService(InMemoryPaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public PaymentResponse createPayment(CreatePaymentRequest request) {
        UUID enrollmentId = request.getEnrollmentId();
        BigDecimal amount = request.getAmount();
        PaymentMethod paymentMethod = request.getPaymentMethod();
        Payment payment = new Payment(enrollmentId, amount, paymentMethod);
        paymentRepository.save(payment);
        return new PaymentResponse(payment.getId(), payment.getAmount(), payment.getPaymentMethod(), payment.getPaymentStatus(), payment.getTransactionReference());


    }

    public PaymentResponse findPaymentById(UUID paymentId) {
        PaymentMapper paymentMapper = new PaymentMapper();
        return paymentMapper.toResponse(paymentRepository.findByID(paymentId));

    }

    public List<PaymentResponse> findAllPayments() {
        PaymentMapper paymentMapper = new PaymentMapper();
        List<Payment> payments = paymentRepository.findAll();
        return paymentMapper.toResponse(payments);

    }

    public PaymentResponse findPaymentsByEnrollmentId(UUID enrollmentId) {
        PaymentMapper paymentMapper = new PaymentMapper();
        return paymentMapper.toResponse(paymentRepository.findByEnrollmentID(enrollmentId));

    }

//    public PaymentResponse updatePaymentStatus(UUID paymentId, UpdatePaymentStatusRequest request) {
//
//    }

    public void deletePayment(UUID paymentId) {
        paymentRepository.delete(paymentId);

    }
}

