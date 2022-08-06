package za.ac.cput.service.restaurant.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.restaurant.Payment;
import za.ac.cput.repository.restaurant.PaymentRepository;
import za.ac.cput.service.restaurant.PaymentService;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {

    private PaymentRepository repository;

    public PaymentServiceImpl(PaymentRepository repository) {
        this.repository = repository;
    }

    public PaymentServiceImpl() {}

    public Payment save (Payment payment) {
        return repository.save(payment);
    }

    public Optional<Payment> read (String paymentId) {
        return repository.findById(paymentId);
    }

    public void delete (Payment payment) {
        repository.delete(payment);
    }

    @Override
    public List<Payment> getAll(String paymentId) {
        return repository.findAll();
    }

    public void deleteById(String paymentId) {
        Optional<Payment> payment = read(paymentId);
        if (payment.isPresent()) delete(payment.get());
    }
}
