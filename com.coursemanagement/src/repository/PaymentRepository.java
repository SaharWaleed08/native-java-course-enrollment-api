package repository;

import model.Payment;

import java.util.List;
import java.util.UUID;

public interface PaymentRepository {
    public UUID save(Payment payment);

    public Payment findByID(UUID id);

    public Payment findByEnrollmentID(UUID enrollmentID);

    public List<Payment> findAll();

}
