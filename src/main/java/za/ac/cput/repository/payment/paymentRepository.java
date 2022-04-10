/*
    paymentRepository.java
    Repository for payment
    Name: Ian Louw
    Student number: 216250773
 */

package za.ac.cput.repository.payment;

import za.ac.cput.entity.Payment;
import za.ac.cput.repository.payment.impl.IPaymentRepository;

import java.util.HashSet;
import java.util.Set;

public class paymentRepository implements IPaymentRepository {

    private static paymentRepository repository = null;
    private Set<Payment> paymentDB = null;

    private paymentRepository() {

        paymentDB = new HashSet<Payment>();
    }

    public static paymentRepository getRepository() {
        if (repository == null) {
            repository = new paymentRepository();
        }
        return repository;
    }

    @Override
    public Payment create (Payment payment) {
        boolean success = paymentDB.add(payment);
        if (!success)
            return null;
        return payment;
    }

    @Override
    public Payment read (Integer paymentId) {
        Payment payment = paymentDB.stream()
                .filter(e -> e.getPaymentId() == paymentId)
                .findAny()
                .orElse(null);
        return payment;
    }

    @Override
    public Payment update (Payment payment) {
        Payment oldPayment = read(payment.getPaymentId());
        if(oldPayment != null) {
            paymentDB.remove(oldPayment);
            paymentDB.add(payment);
            return payment;
        }
        return null;
    }

    @Override
    public boolean delete (Integer paymentId) {
        Payment paymentToDelete = read(paymentId);
        if(paymentToDelete == null)
            return false;
        paymentDB.remove(paymentToDelete);
        return true;
    }

    public Set<Payment> getAll(){
        return paymentDB;
    }
}
