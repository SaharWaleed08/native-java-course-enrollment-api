package repository;

public interface AuditLogRepository {
    public void save();
    public void findByID();
    public void findAll();
    public void findByEntityType();
}
