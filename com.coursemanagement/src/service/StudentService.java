package service;

import dto.mapper.StudentMapper;
import dto.request.RegisterStudentRequest;
import dto.response.StudentResponse;
import model.Student;
import repository.InMemoryStudentRepository;
import repository.StudentRepository;

import java.util.List;
import java.util.UUID;

public class StudentService {
    private InMemoryStudentRepository studentRepository;

    public StudentService(InMemoryStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentResponse registerStudent(RegisterStudentRequest studentRequest) {
        String fullName = studentRequest.getFullName();
        String email = studentRequest.getEmail();
        String password = studentRequest.getPassword();
        Student student = null;
        if (fullName != null && email != null) {
            boolean emailMatches = email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
            boolean passwordMatches = password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$");
            if (emailMatches && passwordMatches) {
                student = new Student(fullName, email, password);
                studentRepository.save(student);
            }

        }
        return new StudentResponse(student.getId(), student.getFullName(), student.getEmail(), student.getRole(), student.getActive());
    }

    public StudentResponse findStudentByID(UUID id) {
        StudentMapper studentMapper = new StudentMapper();
        Student student = studentRepository.findByID(id);
        return studentMapper.toResponse(student);
    }

    public List<StudentResponse> findAllStudent() {
        StudentMapper studentMapper = new StudentMapper();
        List<Student> student = studentRepository.findAll();
        return studentMapper.toResponse(student);

    }
}
