package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.EmployeeRace;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeRaceFactoryTest {
    EmployeeRace employeeRace1;
    EmployeeRace employeeRace2;
    EmployeeRace employeeRace3;


    @BeforeEach
    void setUp() {
        employeeRace1 = EmployeeRaceFactory.createEmployeeRace(89, "Caucasian");
        employeeRace2 = EmployeeRaceFactory.createEmployeeRace(90, "Coloured");
        employeeRace3 = employeeRace1;
    }

    @Test
    public void testEquality(){
        assertEquals(employeeRace1, employeeRace3);
    }
    @Test
    public void testIdentity() {
        assertSame(employeeRace1, employeeRace3);
    }
    @Test
    public void timeoutTest(){
        EmployeeRace employeeRace = EmployeeRaceFactory.createEmployeeRace(67, "Black");
        System.out.println(employeeRace);
    }
    @Test
    public void createEmployeeRace(){
        EmployeeRace employeeRace = EmployeeRaceFactory.createEmployeeRace(100, "Indian");
    }
}