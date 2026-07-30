package dto.mapper;

import dto.request.*;
import dto.response.*;

import model.Course;
import model.Student;

import java.util.ArrayList;
import java.util.List;

public class CourseMapper {

    public Course toEntity(CreateCourseRequest request) {

        return new Course(request.getTitle(), request.getDescription(), request.getPrice(), request.getCapacity());

    }

    public CourseResponse toResponse(Course course) {
        return new CourseResponse(course.getId(), course.getTitle(), course.getDescription(), course.getPrice(), course.getCapacity(), course.getAvailableSeats(), course.getCourseStatus());

    }
    public List<CourseResponse> toResponse(List<Course> courses) {
        List<CourseResponse> responses = new ArrayList<>();

        for (Course course : courses) {
            responses.add(toResponse(course));
        }

        return responses;
    }

}
