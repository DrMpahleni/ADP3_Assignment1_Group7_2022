/*
    paymentRepositoryTest.java
    Repository test for payment
    Name: Ian Louw
    Student number: 216250773
 */

package za.ac.cput.repository.payment;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.restaurant.Payment;
import za.ac.cput.factory.restaurant.paymentFactory;
import za.ac.cput.repository.restaurant.PaymentRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class paymentRepositoryTest {

    private final Payment payment1 = new Payment.Builder()
            .setOrderId("001")
            .setCustomerId("001")
            .setPaymentId("001")
            .setAmount(200)
            .setPaymentType("card")
            .build();

    private static PaymentRepository repository;
    //private static Payment payment = new paymentFactory().createPayment( "01", "01", "Cash", 200);

    @Test
    void create() {
        Payment saved = repository.save(payment1);
        String output = String.valueOf(saved);
        assertNotNull(saved);
        assertSame(saved, output);
    }

    @Test
    void read() {
        Payment saved = repository.save(payment1);
        Optional<Payment> read = repository.findById(saved.getPaymentId());
        String output = String.valueOf(read.get());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertSame(saved, output)
        );
    }

    @Test
    void update() {
        Payment updated = new Payment.Builder().copy(payment1).setAmount(250).build();
        assertNotNull(repository.save(updated));
        System.out.println("Update: " + updated);
    }

    @Test
    void delete() {
        Payment saved = repository.save(payment1);
        List<Payment> getAll = repository.findAll();
        repository.delete(saved);
        assertEquals(0, getAll.size());
    }

    @Test
    void getAll() {
        System.out.println("Show all data: ");
        System.out.println(repository.getAll());
    }
}