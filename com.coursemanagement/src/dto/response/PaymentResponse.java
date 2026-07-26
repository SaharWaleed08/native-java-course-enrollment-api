package dto.response;

import model.PaymentMethod;
import model.PaymentStatus;

import java.math.BigDecimal;
import java.util.UUID;

public class PaymentResponse {

    private UUID id;
    private BigDecimal amount;
    private PaymentMethod paymentMethod;
    private PaymentStatus paymentStatus;
    private String transactionReference;

}