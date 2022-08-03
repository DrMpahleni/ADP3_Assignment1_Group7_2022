package za.ac.cput.domain;
/* ContactTypeTest.java
 This is a Contact Type Entity Test
 Author: Vuyisa Nkangana(218192215)
 Due Date: 10 April 2022
  */
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;


import java.time.Duration;

class ContactTypeTest {
    private ContactTypeTest contact1;
    private ContactTypeTest contact2;
    private ContactTypeTest contact3;

    @BeforeEach
    void setUp() {
        contact1 = new ContactTypeTest();
       contact2 = new ContactTypeTest();
        contact3 = new ContactTypeTest();

    }
    @Test
    @DisplayName("This displays object equality")
    void objectQuality(){
        assertEquals(contact1, contact1);
        System.out.println("The objects are equal");
    }

    @Test
    @DisplayName("This displays object identity")
    void objectIdentity(){
        assertSame(contact1, contact3);
        System.out.println("The objects are identical");
    }

    @Test
    @DisplayName("This displays failed test")
    void failingTest(){
        fail("This is a failed test");
        assertNotSame(contact1, contact2) ;
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
        assertEquals(contact1, contact2);
        System.out.println("Not yet implemented");
    }
}

