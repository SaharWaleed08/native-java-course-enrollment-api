package repository;

import model.Student;

import java.util.List;
import java.util.UUID;

public interface StudentRepository {
    public UUID save(Student student);
    public Student findByID(UUID id);
    public Student findByEmail(String email);
    public List<Student> findAll();
    public boolean existsByEmail(String email);
    public void deleteByID(UUID id);
}
