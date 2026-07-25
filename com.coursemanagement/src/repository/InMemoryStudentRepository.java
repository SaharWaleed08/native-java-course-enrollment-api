package repository;

import model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryStudentRepository implements StudentRepository {
    private int nextId = 1;

    private Map<Integer, Student> students = new HashMap<>();

    @Override
    public Student save(Student student) {

        if (student.getId() == 0) {
            student.setId(nextId++);
        }
        students.put(student.getId(), student);
        return student;
    }

    @Override
    public Student findByID(Integer id) {
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
    public void deleteByID(Integer id) {
        students.remove(id);

    }
}