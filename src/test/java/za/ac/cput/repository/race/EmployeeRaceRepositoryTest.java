package za.ac.cput.repository.race;

/* EmployeeRaceRepositoryTest.java
   This is EmployeeRaceRepository Test case class
   @Author: Lihle Njobe(218193882)
   Due date: 07 August 2022
 */

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.race.EmployeeRace;
import za.ac.cput.factory.race.EmployeeRaceFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)

class EmployeeRaceRepositoryTest {
    private static EmployeeRaceRepository repository = EmployeeRaceRepository.getRepository();
    private static EmployeeRace employeeRace = EmployeeRaceFactory.createEmployeeRace("Coloured ");

    @Test
    void c_create() {
        EmployeeRace created = repository.create(employeeRace);
        assertEquals(employeeRace.getRaceId(),created.getRaceId());
        System.out.println("Created " + created);
    }
    @Test
    void r_read() {
        EmployeeRace read = repository.read(employeeRace.getRaceId());
        assertNotNull(read);
        System.out.println("Read " + read);

    }
    @Test
    void u_update() {
        EmployeeRace updated = new EmployeeRace.Builder().copy(employeeRace).setRaceId(24)
                .setRaceName("Caucasion ")
                .build();
        assertNotNull(repository.update(updated));
        System.out.println(repository.getAll());
    }
    @Test
    void d_delete() {
        boolean success = repository.delete(employeeRace.getRaceId());
        assertTrue(success);
        System.out.println("Employee Race deleted " + success);
    }
    @Test
    void e_getAll() {
        System.out.println("Get all employee races");
        System.out.println(repository.getAll());
    }


}