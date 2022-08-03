/*
    Chef.java
    Test for PositionFactory
    Student:Hlumelo Mpotulo
    Student Number: 215226348
    Due Date 10 April 2022
 */
package za.ac.cput.domain;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.employee.Position;
import za.ac.cput.factory.employee.PositionFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PositionFactoryTest {
    @Test
    public void createPosition(){
        Position position = PositionFactory.createPosition(345,6565,"Chef","Making Orders");
        System.out.println(position);

        assertTrue(position instanceof Position);
    }
}
