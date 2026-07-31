package dto.request;

import model.EnrollmentStatus;

public class UpdateEnrollmentStatusRequest {
    private EnrollmentStatus status;
    public UpdateEnrollmentStatusRequest(EnrollmentStatus status){
        this.status=status;
    }

    public EnrollmentStatus getStatus() {
        return status;
    }

    public void setStatus(EnrollmentStatus status) {
        this.status = status;
    }
}
