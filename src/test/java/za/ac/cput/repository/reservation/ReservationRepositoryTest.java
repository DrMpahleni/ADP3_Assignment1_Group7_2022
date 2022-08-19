/*
ReservationRepositoryTest.java
Author: Felecia Zweni (218330189)
Date: August 2022

 */


package za.ac.cput.repository.reservation;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.restaurant.Reservation;
import za.ac.cput.factory.restaurant.ReservationFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ReservationRepositoryTest {

    private static ReservationRepository repository = ReservationRepository.getRepository();
    private static Reservation reservation = ReservationFactory.createReservation("Julia", 1000, "12/05/2022");

    @Test
    void create() {
        Reservation created = repository.create(reservation);
        assertEquals(ReservationRepository.getRepository(),created.getName());
        System.out.println("Create: " + created);
    }

    @Test
    void read() {
        Reservation read = repository.read(reservation.getName());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void update() {
        Reservation updated = new Reservation.Builder().copy(reservation).setName("Laz").build();
        assertNotNull(repository.update(updated));
        System.out.println("Update: " + updated);
    }

    @Test
    void delete() {
        boolean deleted = repository.delete(reservation.getName());
        assertNotNull(deleted);
        System.out.println("Delete: " + deleted);
    }

    @Test
    void getAll() {
        System.out.println("Show all data: ");
        System.out.println(repository.getAll());
    }

}
