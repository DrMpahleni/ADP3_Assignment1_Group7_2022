package za.ac.cput.entity;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class TableTest {
    private TableTest table1;
    private TableTest table2;
    private TableTest table3;

    @Test
    void setUp(){

        table1 = new TableTest();
        table2 = new TableTest();
        table3 = new TableTest();
        table1 = table3;

    }
    @Test
    @DisplayName("This displays object equality")
    void objectQuality(){
        assertEquals(table1, table2);
        System.out.println("The objects are equal");
    }

    @Test
    @DisplayName("This displays object identity")
    void objectIdentity(){
        assertSame(table1, table3);
        System.out.println("The objects are identical");
    }

    @Test
    @DisplayName("This displays failed test")
    void failingTest(){
        fail("This is a failed test");
        assertNotSame(table1, table2) ;
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
        assertEquals(table1, table1);
        System.out.println("Not yet implemented");
    }
}
