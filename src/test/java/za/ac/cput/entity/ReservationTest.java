package za.ac.cput.entity;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class ReservationTest {

    private ReservationTest reservation1;
    private ReservationTest reservation2;
    private ReservationTest reservation3;

    @Test
    void setUp(){

        reservation1 = new ReservationTest();
        reservation2 = new ReservationTest();
        reservation3 = new ReservationTest();
        reservation1 = reservation3;

    }
    @Test
    @DisplayName("This displays object equality")
    void objectQuality(){
        assertEquals(reservation1, reservation1);
        System.out.println("The objects are equal");
    }

    @Test
    @DisplayName("This displays object identity")
    void objectIdentity(){
        assertSame(reservation1, reservation2);
        System.out.println("The objects are identical");
    }

    @Test
    @DisplayName("This displays failed test")
    void failingTest(){
        fail("This is a failed test");
        assertNotSame(reservation1, reservation2) ;
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
        assertEquals(reservation1, reservation2);
        System.out.println("Not yet implemented");
    }

}
