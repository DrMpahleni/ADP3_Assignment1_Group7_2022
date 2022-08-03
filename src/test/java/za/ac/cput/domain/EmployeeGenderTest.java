package za.ac.cput.domain;

/* EmployeeGenderTest.java
 This is a Employee Gender Entity Test
 Author: Vuyisa Nkangana(218192215)
 Due Date: 10 April 2022
  */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;


import java.time.Duration;


class EmployeeGenderTest {
    private EmployeeGenderTest empGend1;
    private EmployeeGenderTest empGend2;
    private EmployeeGenderTest empGend3;

    @BeforeEach
    void setUp() {
        empGend1 = new EmployeeGenderTest();
        empGend2 = new EmployeeGenderTest();
        empGend3 = new EmployeeGenderTest();

    }
    @Test
    @DisplayName("This displays object equality")
    void objectQuality(){
        assertEquals(empGend1, empGend1);
        System.out.println("The objects are equal");
    }

    @Test
    @DisplayName("This displays object identity")
    void objectIdentity(){
        assertSame(empGend1, empGend3);
        System.out.println("The objects are identical");
    }

    @Test
    @DisplayName("This displays failed test")
    void failingTest(){
        fail("This is a failed test");
        assertNotSame(empGend1, empGend2) ;
    }
    @org.junit.jupiter.api.Test
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
        assertEquals(empGend1, empGend2);
        System.out.println("Not yet implemented");
    }
}