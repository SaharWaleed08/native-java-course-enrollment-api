package repository;

import model.Course;

import java.util.List;
import java.util.UUID;

public interface CourseRepository {
    public UUID save(Course courses);
    public Course findByID(UUID id);
    public List<Course> findAll();
    public void deleteByID(UUID id);
    public boolean existsByID(UUID id);
}
