package za.ac.cput.service.restaurant.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.restaurant.Payment;
import za.ac.cput.service.restaurant.PaymentService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PaymentServiceImplTest {

    private final Payment payment = new Payment.Builder()
            .setPaymentId("0001")
            .setCustomerId("1001")
            .setOrderId("01")
            .setAmount(200)
            .setPaymentType("Card")
            .build();

    @Autowired private PaymentService service;

    @Test
    void save() {
        Payment saved = service.save(payment);
        String output = String.valueOf(saved);
        assertAll(
                () -> assertNotNull(saved),
                () -> assertEquals(payment, output)
        );
        System.out.println(saved);
    }

    @Test
    void read() {
        Payment saved = service.save(payment);
        Optional<Payment> read = service.read(saved.getPaymentId());
        System.out.println(read);
        String output = String.valueOf(read.get());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(payment, output)
        );
    }

    @Test
    void delete() {
        this.service.delete(payment);
    }

    @Test
    void findByPaymentId() {
        Payment saved = service.save(payment);
        String paymentId = saved.getPaymentId();
        List<Payment> paymentList = service.getAll(paymentId);
        System.out.println(paymentList);
        assertSame(1, paymentList.size());
    }

}