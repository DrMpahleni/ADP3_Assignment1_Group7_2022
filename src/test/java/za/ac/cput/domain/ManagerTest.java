package za.ac.cput.domain;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

    private  ManagerTest manager1;
    private ManagerTest manager2;
    private ManagerTest manager3;

    @Test
    void setUp(){

        manager1 = new ManagerTest();
        manager2 = new ManagerTest();
        manager3 = new ManagerTest();
        manager1 = manager3;
    }
    @Test
    @DisplayName("This displays object equality")
    void objectQuality(){
        assertEquals(manager1, manager1);
        System.out.println("The objects are equal");
    }

    @Test
    @DisplayName("This displays object identity")
    void objectIdentity(){
        assertSame(manager1, manager3);
        System.out.println("The objects are identical");
    }

    @Test
    @DisplayName("This displays failed test")
    void failingTest(){
        fail("This is a failed test");
        assertNotSame(manager1, manager2) ;
    }

    @Test
    @DisplayName("This displays timeout")
    void testTimeOut(){
        assertTimeout(Duration.ofMillis(100), () -> {Thread.sleep(2000);

            System.out.println("Test timed out");

        });

    }

    @Test
    @Disabled("This displays a disabled test")
    void disablingTest() {
        assertEquals(manager1, manager2);
        System.out.println("Not yet implemented");
    }


}