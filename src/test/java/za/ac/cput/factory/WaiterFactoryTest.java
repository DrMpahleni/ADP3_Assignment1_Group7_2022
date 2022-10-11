/*

    Test for WaiterFactory
    Student:Hlumelo Mpotulo
    Student Number: 215226348
    Due Date 26 October 2022
 */
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.role.Waiter;
import za.ac.cput.factory.role.WaiterFactory;

import static org.junit.jupiter.api.Assertions.*;

class WaiterFactoryTest {

    @Test
    void createWaiter() {
        Waiter waiter = WaiterFactory.createWaiter(22);
        assertNotNull(waiter);
        System.out.println(waiter);
    }

    @Test
    void createWaiterNot() {
        Waiter waiter = WaiterFactory.createWaiter(0);
        assertNull(waiter);
        System.out.println(waiter);
    }

}