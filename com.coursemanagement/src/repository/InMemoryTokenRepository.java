package repository;

import model.Student;

import java.util.HashMap;
import java.util.Map;

public class InMemoryTokenRepository implements TokenRepository {
    Map<String, Student> tokens = new HashMap<>();

    @Override
    public void save(String token, Student student) {
        tokens.put(token, student);

    }

    @Override
    public Student findByToken(String token) {
        return tokens.get(token);
    }
}
