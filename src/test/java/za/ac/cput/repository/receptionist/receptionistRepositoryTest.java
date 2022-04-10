package za.ac.cput.repository.receptionist;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Receptionist;
import za.ac.cput.factory.ReceptionistFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class receptionistRepositoryTest {

    private static receptionistRepository repository = receptionistRepository.getRepository();
    private static Receptionist receptionist = ReceptionistFactory.createReceptionist(1300,1200);

    @Test
    void create() {
        Receptionist created = repository.create(receptionist);
        assertEquals(receptionist.getReceptionId(),created.getReceptionId());
        System.out.println("Create: " + created);
    }

    @Test
    void read() {
        Receptionist read = repository.read(receptionist.getReceptionId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void update() {
        Receptionist updated = new Receptionist.Builder().copy(receptionist).setReceptionId(300).build();
        assertNotNull(repository.update(updated));
        System.out.println("Update: " + updated);
    }

    @Test
    void delete() {
        boolean deleted = repository.delete(receptionist.getReceptionId());
        assertNotNull(deleted);
        System.out.println("Delete: " + deleted);
    }

    @Test
    void getAll() {
        System.out.println("Show all data: ");
        System.out.println(repository.getAll());
    }

}
