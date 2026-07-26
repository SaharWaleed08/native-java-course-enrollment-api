package dto.response;

import model.EnrollmentStatus;

import java.math.BigDecimal;
import java.util.UUID;

public class EnrollmentResponse {

    private UUID id;
    private UUID studentId;
    private UUID courseId;
    private BigDecimal originalPrice;
    private BigDecimal discountAmount;
    private BigDecimal finalPrice;
    private EnrollmentStatus status;
}