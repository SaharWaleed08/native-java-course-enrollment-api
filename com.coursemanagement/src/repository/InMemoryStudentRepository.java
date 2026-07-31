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
        for (Student student : students.values()) {
            if (student.getEmail().equals(email)) {
                return student;
            }
        }
        return null;
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(students.values());
    }

    @Override
    public boolean existsByEmail(String email) {
        for (Student student : students.values()) {
            if (student.getEmail().equals(email)) {
                return true;
            }
        }
        return false;


    }

    @Override
    public boolean existsById(UUID id) {
        return students.containsKey(id);
    }

    @Override
    public void deleteByID(UUID id) {
        students.remove(id);

    }
}