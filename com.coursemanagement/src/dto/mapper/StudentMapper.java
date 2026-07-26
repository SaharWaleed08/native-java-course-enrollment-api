package dto.mapper;

import dto.request.*;
import dto.response.*;
import model.Student;

public class StudentMapper {

    public Student toEntity(RegisterStudentRequest request) {
        return new Student(request.getFullName(), request.getEmail(), request.getPassword());

    }

    public StudentResponse toResponse(Student student) {
        return new StudentResponse(student.getId(),student.getFullName(),student.getEmail(),student.getRole(),student.getActive());
    }

}