package model;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public class Enrollment {
    private UUID id;
    private UUID studentID;
    private UUID courseID;
    private BigDecimal originalPrice;
    private BigDecimal discountAmount;
    private BigDecimal finalPrice;
    private EnrollmentStatus enrollmentStatus;


    public Enrollment(UUID studentID, UUID courseID) {
        this.id=UUID.randomUUID();
        this.studentID = studentID;
        this.courseID = courseID;
    }

    @Override
    public String toString() {
        return "Enrollment{" +
                "id=" + id +
                ", studentID=" + studentID +
                ", courseID=" + courseID +
                ", originalPrice=" + originalPrice +
                ", discountAmount=" + discountAmount +
                ", finalPrice=" + finalPrice +
                ", enrollmentStatus=" + enrollmentStatus +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Enrollment that = (Enrollment) o;
        return id == that.id && studentID == that.studentID && courseID == that.courseID && Objects.equals(originalPrice, that.originalPrice) && Objects.equals(discountAmount, that.discountAmount) && Objects.equals(finalPrice, that.finalPrice) && enrollmentStatus == that.enrollmentStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, studentID, courseID, originalPrice, discountAmount, finalPrice, enrollmentStatus);
    }

    public UUID getId() {
        return id;
    }



    public UUID getStudentID() {
        return studentID;
    }



    public UUID getCourseID() {
        return courseID;
    }



    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public BigDecimal getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(BigDecimal finalPrice) {
        this.finalPrice = finalPrice;
    }

    public EnrollmentStatus getEnrollmentStatus() {
        return enrollmentStatus;
    }

    public void setEnrollmentStatus(EnrollmentStatus enrollmentStatus) {
        this.enrollmentStatus = enrollmentStatus;
    }
}
