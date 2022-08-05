package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Order;

import static org.junit.jupiter.api.Assertions.*;

class OrderFactoryTest {

    Order order1;
    Order order2;
    Order order3;

    @Test
    public void testEquality(){

        assertEquals(order1, order3);
    }
    @Test
    public void testIdentity() {
        assertSame(order1, order3);
    }
    @Test
    public void timeoutTest(){


    }
}