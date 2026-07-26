package dto.mapper;

import dto.request.*;
import dto.response.*;

import model.Course;

public class CourseMapper {

    public Course toEntity(CreateCourseRequest request) {

        return new Course(request.getTitle(), request.getDescription(), request.getPrice(), request.getCapacity());

    }

    public CourseResponse toResponse(Course course) {
        return new CourseResponse(course.getId(), course.getTitle(), course.getDescription(), course.getPrice(), course.getCapacity(), course.getAvailableSeats(), course.getCourseStatus());

    }

}
