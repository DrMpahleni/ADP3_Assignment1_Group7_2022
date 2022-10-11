package za.ac.cput.service.race;

/* EmployeeRaceServiceTest.java
   This is Employee Race service interface
   @Author: Lihle Njobe(218193882)
   Due date: 14 August 2022
 */

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.race.EmployeeRace;
import za.ac.cput.service.race.impl.EmployeeRaceServiceImpl;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

class EmployeeRaceServiceImplImplTest {

        private final EmployeeRace employeeRace = new EmployeeRace.Builder()
                .setRaceId(89)
                .setRaceName("Black")
                .build();

        @Autowired
        private EmployeeRaceServiceImpl service;

        @Test
        void create() {
            EmployeeRace saved = service.create(employeeRace);
            String output = String.valueOf(saved);
            assertAll(
                    () -> assertNotNull(saved),
                    () -> assertEquals(employeeRace, output)
            );
            System.out.println(saved);
        }

        @Test
        void read() {
            EmployeeRace saved = service.create(employeeRace);
            Optional<EmployeeRace> read = service.read(saved.getRaceId());
            System.out.println(read);
            String output = String.valueOf(read.get());
            assertAll(
                    () -> assertTrue(read.isPresent()),
                    () -> assertEquals(employeeRace, output)
            );
        }

        @Test
        void update () {
            EmployeeRace saved = service.create(employeeRace);
            EmployeeRace updated = new EmployeeRace.Builder().copy(employeeRace).setRaceId(234).build();
            assertNotNull(updated);
            System.out.println(updated);
        }

        @Test
        void delete() {

            this.service.delete(employeeRace);
        }

        @Test
        void findByRaceId() {
            EmployeeRace saved = service.create(employeeRace);
            Integer raceId = saved.getRaceId();
            List<EmployeeRace> employeeRaceList = service.getAll(raceId);
            System.out.println(employeeRaceList);
            assertSame(1, employeeRaceList.size());
        }
    }
