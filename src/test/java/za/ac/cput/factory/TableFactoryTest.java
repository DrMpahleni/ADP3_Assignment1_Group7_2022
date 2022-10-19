package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.restaurant.Table;
import za.ac.cput.factory.restaurant.TableFactory;


import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class TableFactoryTest {


    private Table table1, table2;

    @BeforeEach
    void setUp(){
        Table table1 = new Table.Builder().setTblNum("12").setSeatAmount(8).build();
        Table table2  = table1;
    }


    @Test
    public void test(){

        Table table = TableFactory.createTable("12", 8);
        System.out.println(table.toString());
        assertNotNull(table);

    }

    @Test
    public void testEquality () {
        assertEquals(table1, table2);
        System.out.println("Both tables are equal");
    }

    @Test
    public void testIdentity(){

        assertSame(table1, table2);
        System.out.println("Both tables are identical");
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

        assertEquals(table1, table2);
    }


}
