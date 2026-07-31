package dto.mapper;

import dto.request.*;
import dto.response.*;
import model.Enrollment;
import model.Student;

import java.util.ArrayList;
import java.util.List;

public class EnrollmentMapper {

    public Enrollment toEntity(CreateEnrollmentRequest request) {
        return new Enrollment(request.getStudentId(), request.getCourseId());
    }

    public EnrollmentResponse toResponse(Enrollment enrollment) {
        return new EnrollmentResponse(enrollment.getId(), enrollment.getStudentID(), enrollment.getCourseID(), enrollment.getOriginalPrice(), enrollment.getDiscountAmount(), enrollment.getFinalPrice(), enrollment.getEnrollmentStatus());
    }

    public List<EnrollmentResponse> toResponse(List<Enrollment> enrollments) {
        List<EnrollmentResponse> responses = new ArrayList<>();

        for (Enrollment enrollment : enrollments) {
            responses.add(toResponse(enrollment));
        }

        return responses;
    }
}