package repository;

import model.Enrollment;

import java.util.List;
import java.util.UUID;

public interface EnrollmentRepository {
    public UUID save(Enrollment enrollment);
    public Enrollment findByID(UUID id);
    public List<Enrollment> findAll();
    public Enrollment findByStudentID(UUID studentID);
    public boolean existsByStudentIdAndCourseId(UUID studentID,UUID courseID);
    public void deleteByID(UUID id);
}
