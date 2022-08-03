package za.ac.cput.domain;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {

    private CustomerTest customer1;
    private CustomerTest customer2;
    private CustomerTest customer3;

    @Test
    void setUp(){

        customer1 = new CustomerTest();
        customer2 = new CustomerTest();
        customer3 = new CustomerTest();
        customer1 = customer3;

    }
    @Test
    @DisplayName("This displays object equality")
    void objectQuality(){
        assertEquals(customer1, customer1);
        System.out.println("The objects are equal");
    }

    @Test
    @DisplayName("This displays object identity")
    void objectIdentity(){
        assertSame(customer1, customer3);
        System.out.println("The objects are identical");
    }

    @Test
    @DisplayName("This displays failed test")
    void failingTest(){
        fail("This is a failed test");
        assertNotSame(customer1, customer2) ;
    }

    @Test
    @DisplayName("This displays timeout")
    void testTimeOut(){
        assertTimeout(Duration.ofMillis(100), () -> {Thread.sleep(2000);

            System.out.println("Test timed out");

        });

    }

    @Test
    @Disabled("This displays a disabled test")
    void disablingTest() {
        assertEquals(customer1, customer2);
        System.out.println("Not yet implemented");
    }

}
