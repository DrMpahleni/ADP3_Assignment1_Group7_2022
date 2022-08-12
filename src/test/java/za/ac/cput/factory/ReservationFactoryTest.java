package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.restaurant.Reservation;
import za.ac.cput.factory.restaurant.ReservationFactory;


import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class ReservationFactoryTest {


    private Reservation reservation1, reservation2;

    @BeforeEach
    void setUp(){
        Reservation reservation1 = new Reservation.Builder().setName("Michaelangelo").setAmount(500).setDate(22-05-12/).build();
        Reservation reservation2  = reservation1;
    }


    @Test
    public void test(){

        Reservation reservation = ReservationFactory.createReservation("Michael",1200, 22/05/12/);
        System.out.println(reservation.toString());
        assertNotNull(reservation);

    }

    @Test
    public void testEquality () {
        assertEquals(reservation1, reservation2);
        System.out.println("Both reservations are equal");
    }

    @Test
    public void testIdentity(){

        assertSame(reservation1, reservation2);
        System.out.println("Both reservations are identical");
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

        assertEquals(reservation1, reservation2);
    }



}
