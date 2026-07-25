package repository;

import model.Course;

import java.util.List;

public interface CourseRepository {
    public Course save(Course courses);
    public Course findByID(Integer id);
    public List<Course> findAll();
    public void deleteByID(Integer id);
    public boolean existsByID(Integer id);
}
