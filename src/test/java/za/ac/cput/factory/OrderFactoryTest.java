package za.ac.cput.factory;

/* OrderFactoryTest.java
   This is Order test case class
   @Author: Lihle Njobe(21819388)
   Due date: 07 August 2022
 */

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.lookup.Order;
import za.ac.cput.factory.lookup.OrderFactory;

import static org.junit.jupiter.api.Assertions.*;

class OrderFactoryTest {

    @Test
    void createOrder() {
        Order order = OrderFactory.createOrder(" Burger ", " 16/08/2022", 60);
        System.out.println(order.toString());
        assertNotNull(order);
    }

}