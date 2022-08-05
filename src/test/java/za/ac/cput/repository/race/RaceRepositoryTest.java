package za.ac.cput.repository.race;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Race;
import za.ac.cput.factory.RaceFactory;


import static org.junit.jupiter.api.Assertions.*;

class RaceRepositoryTest {
    private static RaceRepository repository = RaceRepository.getRepository();
    private static Race race = RaceFactory.createRace("789", "Black");

    @Test
    void a_create(){
        Race created = repository.create(race);
        assertEquals(created.getId(), race.getId());
        System.out.println("Create: "+ created);
    }

    @Test
    void b_read(){
        Race read = repository.read(race.getId());
        assertNotNull(read);
        System.out.println("Read: "+ read);
    }

    @Test
    void c_update(){
        Race updated = new Race.Builder().copy(race).setName("Indian").build();
        assertNotNull(repository.update(updated));
        System.out.println("Update: "+ updated);
    }

    @Test
    void d_delete(){
        boolean success = repository.delete(race.getId());
        assertTrue(success);
        System.out.println("Delete: "+ success);
    }

    @Test
    void e_getAll(){
        System.out.println("Show all: ");
        System.out.println(repository.getAll());
    }
}



}