package model;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class AuditLog {
    private UUID id;
    private String action;
    private String entityType;
    private String entityID;
    private String description;
    private LocalDateTime createdAt;

    public AuditLog(){

    }

    public AuditLog( String action, String entityType, String entityID, String description) {
        this.action = action;
        this.entityType = entityType;
        this.entityID = entityID;
        this.description = description;
    }

    @Override
    public String toString() {
        return "AuditLog{" +
                "id=" + id +
                ", action='" + action + '\'' +
                ", entityType='" + entityType + '\'' +
                ", entityID='" + entityID + '\'' +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AuditLog auditLog = (AuditLog) o;
        return id == auditLog.id && Objects.equals(action, auditLog.action) && Objects.equals(entityType, auditLog.entityType) && Objects.equals(entityID, auditLog.entityID) && Objects.equals(description, auditLog.description) && Objects.equals(createdAt, auditLog.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, action, entityType, entityID, description, createdAt);
    }

    public UUID getId() {
        return id;
    }
    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public String getEntityID() {
        return entityID;
    }

    public void setEntityID(String entityID) {
        this.entityID = entityID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
