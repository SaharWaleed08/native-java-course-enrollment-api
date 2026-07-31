package model;

import java.util.Objects;
import java.util.UUID;

public class AuthenticatedUser {

    private UUID id;
    private Role role;

    public AuthenticatedUser(UUID id, Role role) {
        this.id = id;
        this.role = role;
    }

    @Override
    public String toString() {
        return "AuthenticatedUser{" +
                "id=" + id +
                ", role=" + role +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AuthenticatedUser that = (AuthenticatedUser) o;
        return Objects.equals(id, that.id) && role == that.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, role);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}