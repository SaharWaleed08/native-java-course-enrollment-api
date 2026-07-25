package model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Student {
    private int id;
    private String fullName;
    private String email;
    private String password;
    private Role role;
    private CourseStatus active;
    private LocalDateTime createdAt;
    public Student(){

    }

    public Student(int id, String fullName, String email, String password, Role role, CourseStatus active, LocalDateTime createdAt) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.active = active;
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && Objects.equals(fullName, student.fullName) && Objects.equals(email, student.email) && Objects.equals(password, student.password) && role == student.role && active == student.active && Objects.equals(createdAt, student.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, email, password, role, active, createdAt);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", role='"+ role+'\''+
                ", active='"+ active+'\''+
                ", created at ='"+ createdAt+'\''+
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public CourseStatus getActive() {
        return active;
    }

    public void setActive(CourseStatus active) {
        this.active = active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
