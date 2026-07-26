package repository;

import model.Student;

import java.util.*;

public class InMemoryStudentRepository implements StudentRepository {

    private Map<UUID, Student> students = new HashMap<>();

    @Override
    public UUID save(Student student) {


        students.put(student.getId(), student);
        return student.getId();
    }

    @Override
    public Student findByID(UUID id) {
        return students.get(id);
    }

    @Override
    public Student findByEmail(String email) {
        return students.get(email);
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(students.values());
    }

    @Override
    public boolean existsByEmail(String email) {
        if (students.get(email) != null) {
            return true;
        } else {
            return false;
        }


    }

    @Override
    public void deleteByID(UUID id) {
        students.remove(id);

    }
}