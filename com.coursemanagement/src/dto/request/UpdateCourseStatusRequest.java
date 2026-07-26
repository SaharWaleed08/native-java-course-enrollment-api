package dto.request;

import model.CourseStatus;

public class UpdateCourseStatusRequest {

    private CourseStatus status;

    public UpdateCourseStatusRequest(CourseStatus status) {
        this.status = status;
    }

    public CourseStatus getStatus() {
        return status;
    }

    public void setStatus(CourseStatus status) {
        this.status = status;
    }
}