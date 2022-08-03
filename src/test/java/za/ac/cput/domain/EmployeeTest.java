package za.ac.cput.domain;

/*
    EmployeeTest.java
    Testing for Employee
    Student: Ian Louw
    Student Number: 216250773
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    private EmployeeTest employee1;
    private EmployeeTest employee2;
    private EmployeeTest employee3;
    private EmployeeTest employee4;

    @BeforeEach
    void setUp() {
        employee1 = new EmployeeTest();
        employee2 = new EmployeeTest();
        employee3 = new EmployeeTest();
        employee4 = employee3;

    }

    @Test
    @DisplayName("This displays object equality")
    void objectEquality(){

        assertEquals(employee1, employee1);
        System.out.println("Objects are equal");
    }

    @Test
    @DisplayName("This displays object identity")
    void objectIdentity() {
        assertSame(employee3, employee4);
        System.out.println("Objects are identical");
    }

    @Test
    @DisplayName("This displays failed test")
    void failingTest() {
        fail("This is a failed test");
        assertNotSame(employee1, employee2);
    }

    @Test
    @DisplayName("This displays timeout")
    void testTimeOut() {
        assertTimeout(Duration.ofMillis(100), () -> {
            Thread.sleep(2000);

            System.out.println("Test timed out");
        });
    }

    @Test
    @Disabled("This displays a disabled test")
    void disablingTest() {
        assertEquals(employee1, employee2);
        System.out.println("Not yet implemented");
    }
}