package repository;

import model.Course;

import java.util.*;

public class InMemoryCourseRepository implements CourseRepository {
    private Map<UUID, Course> courses = new HashMap<>();

    @Override
    public UUID save(Course course) {

        courses.put(course.getId(), course);
        return course.getId();
    }

    @Override
    public Course findByID(UUID id) {
        return courses.get(id);
    }

    @Override
    public List<Course> findAll() {
        return new ArrayList<>(courses.values());
    }

    @Override
    public void deleteByID(UUID id) {
        courses.remove(id);

    }

    @Override
    public boolean existsByID(UUID id) {
        if (courses.get(id) != null) {
            return true;
        } else {
            return false;
        }


    }


}
