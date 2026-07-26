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
        return enrollments.get(studentID);
    }

    @Override
    public boolean existsByStudentIdAndCourseId(UUID studentID,UUID courseID) {
        if (enrollments.get(studentID)!=null&&enrollments.get(courseID)!=null){
            return true;
        }else {
            return false;
        }

    }

    @Override
    public void deleteByID(UUID id) {
        enrollments.remove(id);

    }
}
