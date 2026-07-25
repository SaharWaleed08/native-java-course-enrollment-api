package repository;

import model.AuditLog;

import java.util.List;

public interface AuditLogRepository {
    public AuditLog save(AuditLog auditLog) ;
    public AuditLog findByID(Integer id);
    public List<AuditLog> findAll();
    public AuditLog findByEntityType(String entityType);
}
