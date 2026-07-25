package repository;

public interface StudentRepository {
    public void save();
    public void findByID();
    public void findByEmail();
    public void findAll();
    public void existsByEmail();
    public void deleteByID();
}
