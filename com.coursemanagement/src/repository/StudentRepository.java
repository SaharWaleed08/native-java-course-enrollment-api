package repository;

import model.Student;

import java.util.List;

public interface StudentRepository {
    public Student save(Student student);
    public Student findByID(Integer id);
    public Student findByEmail(String email);
    public List<Student> findAll();
    public boolean existsByEmail(String email);
    public void deleteByID(Integer id);
}
