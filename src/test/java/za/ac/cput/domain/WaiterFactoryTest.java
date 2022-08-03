/*
    Chef.java
    Test for WaiterFactory
    Student:Hlumelo Mpotulo
    Student Number: 215226348
    Due Date 10 April 2022
 */
package za.ac.cput.domain;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.role.Waiter;
import za.ac.cput.factory.role.WaiterFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;

class WaiterFactoryTest {
    @Test
    public void createWaiter(){
        Waiter waiter = WaiterFactory.createWaiter(55,55004);
        System.out.println(waiter);

        assertTrue (waiter instanceof Waiter);
    }
}
