package za.ac.cput.factory;
/* EmployeeContactFactoryTest.java
 This is a Employee Contact Factory Test Class
 Author: Vuyisa Nkangana(218192215)
 Due Date: 10 April 2022
  */
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.EmployeeContact;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeContactFactoryTest {
    private EmployeeContact contact1;
    private EmployeeContact contact2;
    private EmployeeContact contact3;

    @BeforeEach
    void setUp() {
        EmployeeContact contact = new EmployeeContact.Builder().setEmployeeID("Nka7499").build();
        EmployeeContact contact2 = contact1;
    }

    @Test
    public void test() {

        EmployeeContact employeeContact = EmployeeContactFactory.createEmployeeContact("Nka2001", "empNumb08", "SinoNka");
        System.out.println(employeeContact.toString());
        assertNotNull(employeeContact);
    }

    @Test
    public void testIdentity(){

        assertSame(contact1, contact2);
        System.out.println("Both Employee Contact are identical");
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

        assertEquals(contact1, contact2
        );
    }
}