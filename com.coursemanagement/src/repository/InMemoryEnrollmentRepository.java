package repository;

import model.Course;
import model.Enrollment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryEnrollmentRepository implements EnrollmentRepository {
    private int nextId = 1;

    private Map<Integer, Enrollment> enrollments = new HashMap<>();

    @Override
    public Enrollment save(Enrollment enrollment) {
        if (enrollment.getId() == 0) {
            enrollment.setId(nextId++);
        }
        enrollments.put(enrollment.getId(), enrollment);
        return enrollment;

    }

    @Override
    public Enrollment findByID(Integer id) {
        return enrollments.get(id);
    }

    @Override
    public List<Enrollment> findAll() {
        return new ArrayList<>(enrollments.values());
    }

    @Override
    public Enrollment findByStudentID(Integer studentID) {
        return enrollments.get(studentID);
    }

    @Override
    public boolean existsByStudentIdAndCourseId(Integer studentID,Integer courseID) {
        if (enrollments.get(studentID)!=null&&enrollments.get(courseID)!=null){
            return true;
        }else {
            return false;
        }

    }

    @Override
    public void deleteByID(Integer id) {
        enrollments.remove(id);

    }
}
