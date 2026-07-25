package repository;

import model.Course;
import model.Payment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryPaymentRepository implements PaymentRepository{
    private int nextId = 1;

    private Map<Integer, Payment> payments = new HashMap<>();

    @Override
    public Payment save(Payment payment) {
        if (payment.getId()==0){
            payment.setId(nextId++);
        }
        payments.put(payment.getId(),payment);
        return payment;

    }

    @Override
    public Payment findByID(Integer id) {
        return payments.get(id);
    }

    @Override
    public Payment findByEnrollmentID(Integer enrollmentID) {
        return payments.get(enrollmentID);
    }

    @Override
    public List<Payment> findAll() {
        return new ArrayList<>(payments.values());
    }
}
