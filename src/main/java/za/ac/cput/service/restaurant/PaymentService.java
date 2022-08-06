package za.ac.cput.service.restaurant;

import za.ac.cput.domain.restaurant.Payment;
import za.ac.cput.service.IService;

import java.util.List;

public interface PaymentService extends IService<Payment, String> {

    List<Payment> getAll(String paymentId );
    void deleteById(String paymentId);
}
