package dto.mapper;

import dto.request.*;
import dto.response.*;
import model.Enrollment;

public class EnrollmentMapper {

    public Enrollment toEntity(CreateEnrollmentRequest request) {
        return new Enrollment(request.getStudentId(), request.getCourseId());
    }

    public EnrollmentResponse toResponse(Enrollment enrollment) {
        return new EnrollmentResponse(enrollment.getId(), enrollment.getStudentID(), enrollment.getCourseID(), enrollment.getOriginalPrice(), enrollment.getDiscountAmount(), enrollment.getFinalPrice(), enrollment.getEnrollmentStatus());
    }

}