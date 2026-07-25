package model;

import java.math.BigDecimal;
import java.util.Objects;

public class Enrollment {
    private int id;
    private int studentID;
    private int courseID;
    private BigDecimal originalPrice;
    private BigDecimal discountAmount;
    private BigDecimal finalPrice;
    private EnrollmentStatus enrollmentStatus;

    public Enrollment(){

    }

    public Enrollment(int id, int studentID, int courseID, BigDecimal originalPrice, BigDecimal discountAmount, BigDecimal finalPrice, EnrollmentStatus enrollmentStatus) {
        this.id = id;
        this.studentID = studentID;
        this.courseID = courseID;
        this.originalPrice = originalPrice;
        this.discountAmount = discountAmount;
        this.finalPrice = finalPrice;
        this.enrollmentStatus = enrollmentStatus;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
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
