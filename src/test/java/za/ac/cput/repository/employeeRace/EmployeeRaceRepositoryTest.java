package za.ac.cput.repository.employeeRace;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.EmployeeRace;
import za.ac.cput.factory.EmployeeRaceFactory;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeRaceRepositoryTest {
    private static EmployeeRaceRepository repository = EmployeeRaceRepository.getRepository();
    private static EmployeeRace employeeRace = EmployeeRaceFactory.createEmployeeRace(789, "Black");

    @Test
    void a_create(){
        EmployeeRace created = repository.create(employeeRace);
        assertEquals(created.getRaceId(), employeeRace.getRaceId());
        System.out.println("Create: "+ created);
    }

    @Test
    void b_read(){
        EmployeeRace read = repository.read(employeeRace.getRaceId());
        assertNotNull(read);
        System.out.println("Read: "+ read);
    }

    @Test
    void c_update(){
        EmployeeRace updated = new EmployeeRace.Builder().copy(employeeRace).setRaceName("Indian").build();
        assertNotNull(repository.update(updated));
        System.out.println("Update: "+ updated);
    }

    @Test
    void d_delete(){
        boolean success = repository.delete(employeeRace.getRaceId());
        assertTrue(success);
        System.out.println("Delete: "+ success);
    }

    @Test
    void e_getAll(){
        System.out.println("Show all: ");
        System.out.println(repository.getAll());
    }
}

