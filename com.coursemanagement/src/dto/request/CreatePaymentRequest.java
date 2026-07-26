package dto.request;

import model.PaymentMethod;

import java.math.BigDecimal;
import java.util.UUID;

public class CreatePaymentRequest {

    private UUID enrollmentId;
    private BigDecimal amount;
    private PaymentMethod paymentMethod;

    public CreatePaymentRequest(UUID enrollmentId, BigDecimal amount, PaymentMethod paymentMethod) {
        this.enrollmentId = enrollmentId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
    }

    public UUID getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(UUID enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}