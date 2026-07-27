package repository;

import model.Course;
import model.Enrollment;

import java.util.*;

public class InMemoryEnrollmentRepository implements EnrollmentRepository {

    private Map<UUID, Enrollment> enrollments = new HashMap<>();

    @Override
    public UUID save(Enrollment enrollment) {

        enrollments.put(enrollment.getId(), enrollment);
        return enrollment.getId();

    }

    @Override
    public Enrollment findByID(UUID id) {
        return enrollments.get(id);
    }

    @Override
    public List<Enrollment> findAll() {
        return new ArrayList<>(enrollments.values());
    }

    @Override
    public Enrollment findByStudentID(UUID studentID) {
        for (Enrollment enrollment : enrollments.values()) {
            if (enrollment.getStudentID().equals(studentID)) {
                return enrollment;
            }
        }
        return null;
    }

    @Override
    public boolean existsByStudentIdAndCourseId(UUID studentID, UUID courseID) {
        for (Enrollment enrollment : enrollments.values()) {
            if ((enrollment.getStudentID().equals(studentID)) && (enrollment.getCourseID().equals(courseID))) {
                return true;
            }

        }
        return false;

    }

    @Override
    public void deleteByID(UUID id) {
        enrollments.remove(id);

    }
}
