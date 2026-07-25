package repository;



import model.AuditLog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryAuditLogRepository implements AuditLogRepository{
    private int nextId = 1;

    private Map<Integer, AuditLog> auditLogs = new HashMap<>();

    @Override
    public AuditLog save(AuditLog auditLog) {
        if (auditLog.getId()==0){
            auditLog.setId(nextId++);
        }
        auditLogs.put(auditLog.getId(),auditLog);
        return auditLog;

    }

    @Override
    public AuditLog findByID(Integer id) {
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
