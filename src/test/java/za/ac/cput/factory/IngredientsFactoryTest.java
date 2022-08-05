package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Ingredients;

import static org.junit.jupiter.api.Assertions.*;

class IngredientsFactoryTest {

    Ingredients ingredients1;
    Ingredients ingredients2;
    Ingredients ingredients3;

    @Test
    public void testEquality(){
        assertEquals(ingredients1, ingredients3);
    }
    @Test
    public void testIdentity() {
        assertSame(ingredients1, ingredients3);


    }
}