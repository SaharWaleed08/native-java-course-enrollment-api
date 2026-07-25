package repository;

public interface EnrollmentRepository {
    public void save();
    public void findByID();
    public void findAll();
    public void findByStudentID();
    public void existsByStudentIdAndCourseId();
    public void deleteByID();
}
