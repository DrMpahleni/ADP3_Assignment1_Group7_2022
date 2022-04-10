package za.ac.cput.repository.reservation;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Reservation;
import za.ac.cput.factory.ReservationFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class reservationRepositoryTest {

    private static reservationRepository repository = reservationRepository.getRepository();
    private static Reservation reservation = ReservationFactory.createReservation("Julia", 1000, 22-05-12);

    @Test
    void create() {
        Reservation created = repository.create(reservation);
        assertEquals(reservationRepository.getRepository(),created.getName());
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
