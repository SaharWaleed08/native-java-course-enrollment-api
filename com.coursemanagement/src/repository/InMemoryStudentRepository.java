package repository;

import model.Student;

import java.util.HashMap;
import java.util.Map;

public class InMemoryStudentRepository implements StudentRepository {

    private Map<Integer, Student> students = new HashMap<>();

    @Override
    public void save() {

    }

    @Override
    public void findByID() {

    }

    @Override
    public void findByEmail() {

    }

    @Override
    public void findAll() {

    }

    @Override
    public void existsByEmail() {

    }

    @Override
    public void deleteByID() {

    }
}