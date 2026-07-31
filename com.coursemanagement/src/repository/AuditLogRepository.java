package repository;

import model.AuditLog;

import java.util.List;
import java.util.UUID;

public interface AuditLogRepository {
    public UUID save(AuditLog auditLog) ;
    public AuditLog findByID(UUID id);
    public List<AuditLog> findAll();
    public AuditLog findByEntityType(String entityType);
}
