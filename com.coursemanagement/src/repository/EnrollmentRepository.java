package repository;

import model.Enrollment;

import java.util.List;

public interface EnrollmentRepository {
    public Enrollment save(Enrollment enrollment);
    public Enrollment findByID(Integer id);
    public List<Enrollment> findAll();
    public Enrollment findByStudentID(Integer studentID);
    public boolean existsByStudentIdAndCourseId(Integer studentID,Integer courseID);
    public void deleteByID(Integer id);
}
