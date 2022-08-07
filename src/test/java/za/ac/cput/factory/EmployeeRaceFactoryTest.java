package za.ac.cput.factory;

/* EmployeeRaceTest.java
   This is Employee Race test case class
   @Author: Lihle Njobe(218193882)
   Due date: 07 August 2022
 */

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.race.EmployeeRace;
import za.ac.cput.factory.race.EmployeeRaceFactory;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeRaceFactoryTest {

    @Test
    void createEmployeeRace() {
        EmployeeRace employeeRace = EmployeeRaceFactory.createEmployeeRace("Black");
        System.out.println(employeeRace.toString());
        assertNotNull(employeeRace);

    }

}