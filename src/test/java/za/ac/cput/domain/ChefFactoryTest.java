/*
    Chef.java
    Test for ChefFactory
    Student:Hlumelo Mpotulo
    Student Number: 215226348
    Due Date 10 April 2022
 */
package za.ac.cput.domain;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.role.Chef;
import za.ac.cput.factory.role.ChefFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ChefFactoryTest {
    @Test
    public void createChef()
    {
        Chef chef = ChefFactory.createChef(545,55007);
        System.out.println(chef);

        assertTrue(chef instanceof Chef);
    }

}
