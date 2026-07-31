package dto.request;

import java.util.UUID;

public class CreateEnrollmentRequest {

    private UUID studentId;
    private UUID courseId;

    public CreateEnrollmentRequest(UUID studentId, UUID courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }

    public UUID getStudentId() {
        return studentId;
    }

    public void setStudentId(UUID studentId) {
        this.studentId = studentId;
    }

    public UUID getCourseId() {
        return courseId;
    }

    public void setCourseId(UUID courseId) {
        this.courseId = courseId;
    }
}