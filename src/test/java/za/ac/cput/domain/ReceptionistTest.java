package za.ac.cput.domain;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.role.Receptionist;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class ReceptionistTest {

    private Receptionist receptionist1;
    private Receptionist receptionist2;
    private Receptionist receptionist3;


    @Test
    void setUp(){

        receptionist1 = new Receptionist();
        receptionist2 = new Receptionist();
        receptionist3 = new Receptionist();
        receptionist1 =  receptionist3;

    }

    @Test
    void objectQuality(){
        assertEquals(receptionist1, receptionist1);
        System.out.println("The objects are equal");
    }

    @Test
    void objectIdentity(){
        assertSame(receptionist1, receptionist3);
        System.out.println("The objects are identical");
    }

    @Test
    void failingTest(){
        fail("This is a failed test");
        assertNotSame(receptionist1, receptionist2) ;
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
        assertEquals(receptionist1, receptionist2);
        System.out.println("Not yet implemented");
    }





}
