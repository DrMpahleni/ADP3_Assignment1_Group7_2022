/*
    paymentRepositoryTest.java
    Repository test for payment
    Name: Ian Louw
    Student number: 216250773
 */

package za.ac.cput.repository.payment;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Payment;
import za.ac.cput.factory.paymentFactory;

import static org.junit.jupiter.api.Assertions.*;

class paymentRepositoryTest {

    private static paymentRepository repository = paymentRepository.getRepository();
    private static Payment payment = new paymentFactory().createPayment("01", "01", "01", "Cash", 200);

    @Test
    void create() {
        Payment created = repository.create(payment);
        assertEquals(payment.getPaymentId(),created.getPaymentId());
        System.out.println("Create: " + created);
    }

    @Test
    void read() {
        Payment read = repository.read(payment.getPaymentId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void update() {
        Payment updated = new Payment.Builder().copy(payment).setAmount(250).build();
        assertNotNull(repository.update(updated));
        System.out.println("Update: " + updated);
    }

    @Test
    void delete() {
        boolean deleted = repository.delete(payment.getPaymentId());
        assertNotNull(deleted);
        System.out.println("Delete: " + deleted);
    }

    @Test
    void getAll() {
        System.out.println("Show all data: ");
        System.out.println(repository.getAll());
    }
}