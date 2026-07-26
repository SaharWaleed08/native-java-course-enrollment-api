package repository;



import model.AuditLog;

import java.util.*;

public class InMemoryAuditLogRepository implements AuditLogRepository{

    private Map<UUID, AuditLog> auditLogs = new HashMap<>();

    @Override
    public UUID save(AuditLog auditLog) {

        auditLogs.put(auditLog.getId(),auditLog);
        return auditLog.getId();

    }

    @Override
    public AuditLog findByID(UUID id) {
        return auditLogs.get(id);
    }

    @Override
    public AuditLog findByEntityType(String entityType) {
        return auditLogs.get(entityType);
    }

    @Override
    public List<AuditLog> findAll() {
        return new ArrayList<>(auditLogs.values());
    }
}
