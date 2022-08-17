package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.role.Customer;
import za.ac.cput.factory.role.CustomerFactory;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerFactoryTest {

    private Customer customer1;
    private Customer customer2;

    @BeforeEach
    void setUp(){
        Customer customer1 = new Customer.Builder().setCustomerName("Felecia").setCustomerId("1222").build();
        Customer customer2 = customer1;
    }

    @Test
    public void test(){

        Customer customer = CustomerFactory.createCustomer("1222", "Felecia");
        System.out.println(customer.toString());
        assertNotNull(customer);

    }

    @Test
    public void testEquality () {
        assertEquals(customer1, customer2);
        System.out.println("Both customers are equal");
    }

    @Test
    public void testIdentity(){

        assertSame(customer1, customer2);
        System.out.println("Both customers are identical");
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

        assertEquals(customer1, customer2);
    }











}
