package za.ac.cput.entity;

/* EmployeeContactTest.java
 This is a Employee Contact Entity Test
 Author: Vuyisa Nkangana(218192215)
 Due Date: 10 April 2022
  */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;


    class EmployeeContactTest {

        private EmployeeContactTest employC1;
        private EmployeeContactTest employC2;
        private EmployeeContactTest employC3;


        @BeforeEach
        void setUp() {
            employC1 = new EmployeeContactTest();
            employC2 = new EmployeeContactTest();
            employC3 = new EmployeeContactTest();
            employC3 = employC2;

        }

        @Test
        @DisplayName("This displays object equality")
        void objectEquality(){

            assertEquals(employC1, employC1);
            System.out.println("Objects are equal");
        }

        @Test
        @DisplayName("This displays object identity")
        void objectIdentity() {
            assertSame(employC2, employC3);
            System.out.println("Objects are identical");
        }

        @Test
        @DisplayName("This displays failed test")
        void failingTest() {
            fail("This is a failed test");
            assertNotSame(employC1, employC2);
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
            assertEquals(employC1, employC2);
            System.out.println("Not yet implemented");
        }
    }

