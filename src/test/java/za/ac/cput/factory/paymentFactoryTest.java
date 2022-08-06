/*
    paymentFactoryTest.java
    factory test for payment
    Student: Ian Louw
    Student Number: 216250773
 */

package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.restaurant.Payment;
import za.ac.cput.factory.restaurant.paymentFactory;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class paymentFactoryTest {

    private Payment payment1;
    private Payment payment2;

    @BeforeEach
    void setUp() {
        Payment payment1 = new Payment.Builder().setPaymentType("Cash").build();
        Payment payment2 = payment1;
    }

    @Test
    public void test() {

        Payment payment = paymentFactory.createPayment("0", "0","card", 100);
        System.out.println(payment.toString());
        assertNotNull(payment);

    }

    @Test
    public void testEquality () {
        assertEquals(payment1, payment2);
        System.out.println("Both payments are equal");
    }

    @Test
    public void testIdentity(){

        assertSame(payment1, payment2);
        System.out.println("This payments are identical");
    }

    @Test
    void testTimeout() {

        assertTimeout(Duration.ofMinutes(100), () -> {
            Thread.sleep(2000);

            System.out.println("Test Timed out");
        });
    }

    @Test
    @Disabled
    void testDisable() {

        assertEquals(payment1, payment2);
    }
}