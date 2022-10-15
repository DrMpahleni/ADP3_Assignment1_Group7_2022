package za.ac.cput.repository.race;

/* EmployeeRaceTest.java
   This is EmployeeRace Repository Test case class
   @Author: Lihle Njobe(218193882)
   Due date: 07 August 2022
 */

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.domain.race.EmployeeRace;
import za.ac.cput.factory.race.EmployeeRaceFactory;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)

class EmployeeRaceRepositoryTest {

    private final EmployeeRace employeeRace1 = new EmployeeRace.Builder()
            .setRaceId(678)
            .setRaceName("Caucasian")
            .build();

    @Autowired
    private EmployeeRaceRepository repository;
    private static EmployeeRace employeeRace = EmployeeRaceFactory.createEmployeeRace("Coloured ");

    @Test
    void c_create() {
        EmployeeRace created = repository.save(employeeRace);
        assertEquals(employeeRace.getRaceId(),created.getRaceName());
        System.out.println("Created " + created);
    }
    @Test
    void r_read() {
        EmployeeRace read = repository.getById(employeeRace.getRaceId());
        assertNotNull(read);
        System.out.println("Read " + read);

    }
    @Test
    void u_update() {
        EmployeeRace updated = new EmployeeRace.Builder().copy(employeeRace)
                .setRaceId(456)
                .setRaceName("Black ")
                .build();
        assertNotNull(repository.save(updated));
        System.out.println(repository.getAll());
    }
    @Test
    void d_delete() {
        EmployeeRace saved = repository.save(employeeRace);
        List<EmployeeRace> getAll = repository.findAll();
        repository.delete(saved);
        assertEquals(0, getAll.size());
    }
    @Test
    void e_getAll() {
        repository.save(employeeRace1);
        List<EmployeeRace> getAll = repository.findAll();
        assertEquals(1, getAll.size());

    }

}
