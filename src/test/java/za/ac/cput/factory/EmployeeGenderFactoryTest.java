package za.ac.cput.factory;

/* EmployeeGenderFactoryTest.java
 This is a Employee Gender Factory Test Class
 Author: Vuyisa Nkangana(218192215)
 Due Date: 10 April 2022
  */
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.EmployeeGender;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeGenderFactoryTest {
    private EmployeeGender empGend1;
    private EmployeeGender empGend2;
    private EmployeeGender empGend3;

    @BeforeEach
    void setUp() {
        EmployeeGender employeeGender = new EmployeeGender.Builder().setEmployeeId("Mavo2001").build();
        EmployeeGender empGend2 = empGend1;
    }

    @Test
    public void test() {

        EmployeeGender employeeGender = EmployeeGenderFactory.createEmployeeGender("Siv2004", "Female00");
        System.out.println(employeeGender.toString());
        assertNotNull(employeeGender);
    }

    @Test
    public void testIdentity(){

        assertSame(empGend1, empGend2);
        System.out.println("Both Employee Genders are identical");
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

        assertEquals(empGend1, empGend2
        );
    }

}