/*
    EmployeeFactoryTest.java
    factory test for Employee
    Student: Ian Louw
    Student Number: 216250773
 */

package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.contact.EmployeeContact;
import za.ac.cput.domain.employee.Employee;
import za.ac.cput.domain.employee.Position;
import za.ac.cput.domain.gender.EmployeeGender;
import za.ac.cput.domain.race.EmployeeRace;
import za.ac.cput.factory.employee.EmployeeFactory;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeFactoryTest {

    private Employee employee1;
    private Employee employee2;

    @BeforeEach
    void setUp() {
        Employee employee1 = new Employee.Builder().setFirstName("Dylan").build();
        Employee employee2 = employee1;
    }

    @Test
    public void test() {

        EmployeeGender gender = new EmployeeGender.Builder().setGenderId("01").setEmployeeId("0001").build();
        EmployeeRace race = new EmployeeRace.Builder().setRaceId(0004).setRaceName("Coloured").build();
        EmployeeContact contact = new EmployeeContact.Builder().setContact("0715556789").build();
        Position position1 = new Position.Builder().setPositionName("Manager").build();
        Employee employee = EmployeeFactory.createEmployee("Ian", "Louw", gender, race, contact, position1);
        System.out.println(employee.toString());
        assertNotNull(employee);
    }

    @Test
    public void testEquality () {
        assertEquals(employee1, employee2);
        System.out.println("Both employees are equal");
    }

    @Test
    public void testIdentity(){

        assertSame(employee1, employee2);
        System.out.println("Both employees are identical");
    }

    @Test
    void testTimeout() {

        assertTimeout(Duration.ofMinutes(100), () -> {
            Thread.sleep(2000);

            System.out.println("Test Timed out");
        });
    }

    @Test
    @Disabled
    void testDisable() {

        assertEquals(employee1, employee2);
    }
}