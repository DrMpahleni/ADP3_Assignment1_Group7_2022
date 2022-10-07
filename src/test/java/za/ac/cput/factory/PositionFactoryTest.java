/*

    Test for PositionFactory
    Student:Hlumelo Mpotulo
    Student Number: 215226348
    Due Date 26 October 2022
 */
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.employee.Position;
import za.ac.cput.factory.employee.PositionFactory;

import static org.junit.jupiter.api.Assertions.*;

class PositionFactoryTest {

    @Test
    void createPosition() {
        Position position = PositionFactory.createPosition("Manager", "Managing Staff", 112);
        assertNotNull(position);
        System.out.println(position);
    }

    @Test
    void createPositionNot() {
        Position position = PositionFactory.createPosition("Manager", "", 112);
        assertNull(position);
        System.out.println(position);
    }
}