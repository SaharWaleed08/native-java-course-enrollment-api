package repository;

import model.Course;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryCourseRepository implements CourseRepository {
    private int nextId = 1;

    private Map<Integer, Course> courses = new HashMap<>();

    @Override
    public Course save(Course course) {

        if (course.getId() == 0) {
            course.setId(nextId++);
        }
        courses.put(course.getId(), course);
        return course;
    }

    @Override
    public Course findByID(Integer id) {
        return courses.get(id);
    }

    @Override
    public List<Course> findAll() {
        return new ArrayList<>(courses.values());
    }

    @Override
    public void deleteByID(Integer id) {
        courses.remove(id);

    }

    @Override
    public boolean existsByID(Integer id) {
        if (courses.get(id) != null) {
            return true;
        } else {
            return false;
        }


    }


}
