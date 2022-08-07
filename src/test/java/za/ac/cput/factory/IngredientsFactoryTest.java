package za.ac.cput.factory;

/* IngredientsFactoryTest.java
   This is Ingredients Test case class
   @Author: Lihle Njobe(21819388)
   Due date: 07 August 2022
 */

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.lookup.Ingredients;
import za.ac.cput.factory.lookup.IngredientsFactory;

import static org.junit.jupiter.api.Assertions.*;

class IngredientsFactoryTest {

    @Test
    void createIngredients() {
        Ingredients ingredients = IngredientsFactory.createIngredients(" Cheese ", " Solid ", 40);
        System.out.println(ingredients.toString());
        assertNotNull(ingredients);
    }

}