package service;

import dto.mapper.EnrollmentMapper;
import dto.request.CreateEnrollmentRequest;
import dto.request.UpdateEnrollmentStatusRequest;
import dto.response.EnrollmentResponse;
import model.Enrollment;
import repository.InMemoryCourseRepository;
import repository.InMemoryEnrollmentRepository;
import repository.InMemoryStudentRepository;

import java.util.List;
import java.util.UUID;

public class EnrollmentService {
    private InMemoryEnrollmentRepository enrollmentRepository;

    public EnrollmentService(InMemoryEnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;

    }


    public EnrollmentResponse enrollStudent(CreateEnrollmentRequest request) {
        UUID studentId = request.getStudentId();
        UUID courseId = request.getCourseId();
        Enrollment enrollment = null;
        InMemoryStudentRepository studentRepository = new InMemoryStudentRepository();
        InMemoryCourseRepository courseRepository = new InMemoryCourseRepository();
        if (studentRepository.existsById(studentId) && courseRepository.existsByID(courseId)) {
            enrollment = new Enrollment(studentId, courseId);
            enrollmentRepository.save(enrollment);
        }
        return new EnrollmentResponse(enrollment.getId(),enrollment.getStudentID(),enrollment.getCourseID(),enrollment.getOriginalPrice(),enrollment.getDiscountAmount(),enrollment.getFinalPrice(),enrollment.getEnrollmentStatus());

    }

    public EnrollmentResponse findEnrollmentById(UUID enrollmentId) {
        EnrollmentMapper enrollmentMapper = new EnrollmentMapper();
        return enrollmentMapper.toResponse(enrollmentRepository.findByID(enrollmentId));


    }

    public List<EnrollmentResponse> findAllEnrollments() {
        EnrollmentMapper enrollmentMapper = new EnrollmentMapper();
        List<Enrollment> enrollments = enrollmentRepository.findAll();
        return enrollmentMapper.toResponse(enrollments);

    }

    public EnrollmentResponse findEnrollmentsByStudentId(UUID studentId) {
        EnrollmentMapper enrollmentMapper = new EnrollmentMapper();
        return enrollmentMapper.toResponse(enrollmentRepository.findByStudentID(studentId));
    }

    public EnrollmentResponse findEnrollmentsByCourseId(UUID courseId) {
        EnrollmentMapper enrollmentMapper = new EnrollmentMapper();
        return enrollmentMapper.toResponse(enrollmentRepository.findByCourseID(courseId));
    }

//    public EnrollmentResponse updateEnrollmentStatus(UUID enrollmentId, UpdateEnrollmentStatusRequest request) {
//
//    }

    public void deleteEnrollment(UUID enrollmentId) {
        enrollmentRepository.deleteByID(enrollmentId);
    }
}