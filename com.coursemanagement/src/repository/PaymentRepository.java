package repository;

import model.Payment;

import java.util.List;

public interface PaymentRepository {
    public Payment save(Payment payment);

    public Payment findByID(Integer id);

    public Payment findByEnrollmentID(Integer enrollmentID);

    public List<Payment> findAll();

}
