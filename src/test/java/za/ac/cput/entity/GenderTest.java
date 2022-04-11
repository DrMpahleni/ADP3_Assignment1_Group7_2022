package za.ac.cput.entity;

/* GenderTest.java
 This is a Gender Entity Test
 Author: Vuyisa Nkangana(218192215)
 Due Date: 10 April 2022
  */

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;

class GenderTest {
    private GenderTest gender1;
    private GenderTest gender2;
    private GenderTest gender3;

    @BeforeEach
    void setUp() {
        gender1 = new GenderTest();
        gender1 = new GenderTest();
        gender1 = new GenderTest();

    }
    @Test
    @DisplayName("This displays object equality")
    void objectQuality(){
        assertEquals(gender1, gender1);
        System.out.println("The objects are equal");
    }

    @Test
    @DisplayName("This displays object identity")
    void objectIdentity(){
        assertSame(gender1, gender3);
        System.out.println("The objects are identical");
    }

    @Test
    @DisplayName("This displays failed test")
    void failingTest(){
        fail("This is a failed test");
        assertNotSame(gender1, gender2) ;
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
        assertEquals(gender1, gender2);
        System.out.println("Not yet implemented");
    }

}