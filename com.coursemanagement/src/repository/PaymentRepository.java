package repository;

public interface PaymentRepository {
    public void save();
    public void findByID();
    public void findByEnrollmentID();
    public void findAll();

}
