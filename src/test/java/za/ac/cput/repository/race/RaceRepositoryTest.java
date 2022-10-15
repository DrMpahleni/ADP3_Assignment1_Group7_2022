package za.ac.cput.repository.race;

/* RaceTest.java
   This is Race Repository Test case class
   @Author: Lihle Njobe(218193882)
   Due date: 07 August 2022
 */

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.domain.race.Race;
import za.ac.cput.factory.race.RaceFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)

class RaceRepositoryTest {

    private final Race race1 = new Race.Builder()
            .setId(678)
            .setName("Caucasian")
            .build();

    @Autowired
    private RaceRepository repository;
    private static Race race = RaceFactory.createRace("Coloured ");

    @Test
    void c_create() {
        Race created = repository.save(race);
        assertEquals(race.getId(),created.getName());
        System.out.println("Created " + created);
    }
    @Test
    void r_read() {
        Race read = repository.getById(race.getId());
        assertNotNull(read);
        System.out.println("Read " + read);

    }
    @Test
    void u_update() {
        Race updated = new Race.Builder().copy(race)
                .setId(456)
                .setName("Black ")
                .build();
        assertNotNull(repository.save(updated));
        System.out.println(repository.getAll());
    }
    @Test
    void d_delete() {
        Race saved = repository.save(race);
        List<Race> getAll = repository.findAll();
        repository.delete(saved);
        assertEquals(0, getAll.size());
    }
    @Test
    void e_getAll() {
        repository.save(race1);
        List<Race> getAll = repository.findAll();
        assertEquals(1, getAll.size());

    }

    }