package dto.mapper;

import dto.request.*;
import dto.response.*;
import model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentMapper {

    public Student toEntity(RegisterStudentRequest request) {
        return new Student(request.getFullName(), request.getEmail(), request.getPassword());

    }

    public StudentResponse toResponse(Student student) {
        return new StudentResponse(student.getId(),student.getFullName(),student.getEmail(),student.getRole(),student.getActive());
    }
    public List<StudentResponse> toResponse(List<Student> students) {
        List<StudentResponse> responses = new ArrayList<>();

        for (Student student : students) {
            responses.add(toResponse(student));
        }

        return responses;
    }
}