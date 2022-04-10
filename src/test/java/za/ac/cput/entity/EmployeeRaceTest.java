package za.ac.cput.entity;
/*
EmployeeRaceTest.Java
Test Case for EmployeeRace
@author Lihle Njobe 218193882
Due date: 10 April 2022
 */
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.factory.EmployeeRaceFactory;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeRaceTest {

    @Test
    public void EmployeeRace() {
        EmployeeRace employeeRace = EmployeeRaceFactory.createEmployeeRace(001, " Black ");
        System.out.println(employeeRace);

    }

    @Test
    public void testEquality() {
        EmployeeRace.Builder type0 = new EmployeeRace.Builder().setRaceName("African American").setRaceId("003");
        EmployeeRace.Builder type1 = new EmployeeRace.Builder().setRaceName("African American").setRaceId("003");
        type0 = type1;
        assertEquals(type0, type1);
        System.out.println(" assert Equals");

    }

    @Test
    public void testIdentity() {
        EmployeeRace.Builder type0 = new EmployeeRace.Builder().setRaceId("007").setRaceName("White");
        EmployeeRace.Builder type1 = new EmployeeRace.Builder().setRaceId("007").setRaceName("White");
        type0 = type1;
        assertSame(type0, type1);
        System.out.print("assertSame");

    }

    @Test
    public void testTimeout() {
        AssertTimeout(3);
        System.out.println("Time out");
        }

    private void AssertTimeout(int i) {
    }

    @Test
    @Disabled(" When the timeout is exceeded")
    public void testWillBeExecuted() {
    }
}