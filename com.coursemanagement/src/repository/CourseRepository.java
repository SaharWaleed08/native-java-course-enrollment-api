package repository;

public interface CourseRepository {
    public void save();
    public void findByID();
    public void findAll();
    public void deleteByID();
    public void existsByID();
}
