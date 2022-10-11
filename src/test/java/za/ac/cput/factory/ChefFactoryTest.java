/*
    Chef.java
    Test for ChefFactory
    Student:Hlumelo Mpotulo
    Student Number: 215226348
    Due Date 26 October 2022
 */
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.role.Chef;
import za.ac.cput.factory.role.ChefFactory;

import static org.junit.jupiter.api.Assertions.*;

class ChefFactoryTest {

    @Test
    void createChef() {
        Chef chef = ChefFactory.createChef(10);
        assertNotNull(chef);
        System.out.println(chef);
    }

    @Test
    void createChefNot() {
        Chef chef = ChefFactory.createChef(0);
        assertNull(chef);
        System.out.println(chef);
    }
}