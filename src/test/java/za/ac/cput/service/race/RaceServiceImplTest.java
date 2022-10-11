package za.ac.cput.service.race;

/* RaceServiceTest.java
   This is Race service interface
   @Author: Lihle Njobe(218193882)
   Due date: 14 August 2022
 */

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.race.Race;
import za.ac.cput.service.race.impl.RaceServiceImpl;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RaceServiceImplTest {

    private final Race race = new Race.Builder()
            .setId(89)
            .setName("Black")
            .build();

    @Autowired
    private RaceServiceImpl service;

    @Test
    void create() {
        Race saved = service.create(race);
        String output = String.valueOf(saved);
        assertAll(
                () -> assertNotNull(saved),
                () -> assertEquals(race, output)
        );
        System.out.println(saved);
    }

    @Test
    void read() {
        Race saved = service.create(race);
        Optional<Race> read = service.read(saved.getId());
        System.out.println(read);
        String output = String.valueOf(read.get());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(race, output)
        );
    }

    @Test
    void update () {
        Race saved = service.create(race);
        Race updated = new Race.Builder().copy(race).setId(234).build();
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    void delete() {

        this.service.delete(race);
    }

    @Test
    void findById() {
        Race saved = service.create(race);
        Integer id = saved.getId();
        List<Race> raceList = service.getAll(id);
        System.out.println(raceList);
        assertSame(1, raceList.size());
    }

}