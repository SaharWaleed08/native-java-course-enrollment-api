package repository;

import model.Course;
import model.Payment;

import java.util.*;

public class InMemoryPaymentRepository implements PaymentRepository {

    private Map<UUID, Payment> payments = new HashMap<>();

    @Override
    public UUID save(Payment payment) {

        payments.put(payment.getId(), payment);
        return payment.getId();

    }

    @Override
    public Payment findByID(UUID id) {
        return payments.get(id);
    }

    @Override
    public Payment findByEnrollmentID(UUID enrollmentID) {
        for (Payment payment : payments.values()) {
            if (payment.getEnrollmentID().equals(enrollmentID)) {
                return payment;
            }
        }
        return null;
    }

    @Override
    public List<Payment> findAll() {
        return new ArrayList<>(payments.values());
    }


    @Override
    public void delete(UUID paymentId) {
        payments.remove(paymentId);
    }
}
