package service;

import dto.mapper.CourseMapper;
import dto.request.CreateCourseRequest;
import dto.request.UpdateCourseRequest;
import dto.request.UpdateCourseStatusRequest;
import dto.response.CourseResponse;
import model.Course;
import model.CourseStatus;
import repository.InMemoryCourseRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class CourseService {
    private InMemoryCourseRepository courseRepository;

    public CourseService(InMemoryCourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public CourseResponse createCourse(CreateCourseRequest courseRequest) {
        String title = courseRequest.getTitle();
        String description = courseRequest.getDescription();
        BigDecimal price = courseRequest.getPrice();
        int capacity = courseRequest.getCapacity();
        Course course = null;
        if ((title != null) && (description != null) && (price.compareTo(BigDecimal.ZERO) > 0) && (capacity > 0)) {
            course = new Course(title, description, price, capacity);
            course.setAvailableSeats(capacity);
            course.setCourseStatus(CourseStatus.ACTIVE);
            courseRepository.save(course);

        }
        return new CourseResponse(course.getId(),course.getTitle(),course.getDescription(),course.getPrice(),course.getCapacity(),course.getAvailableSeats(),course.getCourseStatus());

    }

    public CourseResponse findCourseById(UUID id) {
        CourseMapper courseMapper=new CourseMapper();
        return courseMapper.toResponse(courseRepository.findByID(id));
    }

    public List<CourseResponse> findAllCourse() {
        CourseMapper courseMapper=new CourseMapper();
        List<Course> courses = courseRepository.findAll();
        return courseMapper.toResponse(courses);
    }

    public CourseResponse replaceCourse(UUID courseId, UpdateCourseRequest updateCourseRequest) {
        Course course = courseRepository.findByID(courseId);
        course.setTitle(updateCourseRequest.getTitle());
        course.setDescription(updateCourseRequest.getDescription());
        course.setPrice(updateCourseRequest.getPrice());
        course.setCapacity(updateCourseRequest.getCapacity());
        course.setAvailableSeats(course.getCapacity());
        return new CourseResponse(courseId, course.getTitle(), course.getDescription(), course.getPrice(), course.getCapacity(), course.getAvailableSeats(), course.getCourseStatus());

    }

    public CourseResponse updateCourseStatus(UUID courseId, UpdateCourseStatusRequest updateCourseStatusRequest) {
        Course course = courseRepository.findByID(courseId);
        course.setCourseStatus(updateCourseStatusRequest.getStatus());
        return new CourseResponse(courseId, course.getTitle(), course.getDescription(), course.getPrice(), course.getCapacity(), course.getAvailableSeats(), course.getCourseStatus());

    }

    public String deleteCourse(UUID courseId) {
        courseRepository.deleteByID(courseId);
        return "Course Deleted :)";
    }
}
