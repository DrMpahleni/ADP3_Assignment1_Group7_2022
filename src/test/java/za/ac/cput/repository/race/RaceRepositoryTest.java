package za.ac.cput.repository.race;

/* RaceRepositoryTest.java
   This is ERaceRepository Test case class
   @Author: Lihle Njobe(21819388)
   Due date: 07 August 2022
 */

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.race.Race;
import za.ac.cput.factory.race.RaceFactory;


import static org.junit.jupiter.api.Assertions.*;

class RaceRepositoryTest {

    private static RaceRepository repository = RaceRepository.getRepository();
    private static Race race = RaceFactory.createRace("Coloured ");

    @Test
    void c_create() {
        Race created = repository.create(race);
        assertEquals(race.getId(),created.getId());
        System.out.println("Created " + created);
    }
    @Test
    void r_read() {
        Race read = repository.read(race.getId());
        assertNotNull(read);
        System.out.println("Read " + read);

    }
    @Test
    void u_update() {
        Race updated = new Race.Builder().copy(race).setId(24)
                .setName("Caucasion ")
                .build();
        assertNotNull(repository.update(updated));
        System.out.println(repository.getAll());
    }
    @Test
    void d_delete() {
        boolean success = repository.delete(race.getId());
        assertTrue(success);
        System.out.println("Race deleted " + success);
    }
    @Test
    void e_getAll() {
        System.out.println("Get all races");
        System.out.println(repository.getAll());
    }

}

