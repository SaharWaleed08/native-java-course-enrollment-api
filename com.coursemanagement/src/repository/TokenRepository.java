package repository;

import model.Student;

public interface TokenRepository {
   public void save(String token, Student student);

   public Student findByToken(String token);
}
