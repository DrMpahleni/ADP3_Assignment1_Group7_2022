package za.ac.cput.entity;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.factory.IngredientsFactory;


import static org.junit.jupiter.api.Assertions.*;

class IngredientsTest {

    @Test
    public void Ingredients() {
        Ingredients ingredients = IngredientsFactory.createIngredients("Milk", "Liquid", 20);
        System.out.println(ingredients);
    }
    @Test
    public void testEquality() {
        Ingredients.Builder type0 = new Ingredients.Builder().setIngredientName("Flour").setIngredientType("Powder").setAmount(40);
        Ingredients.Builder type1 = new Ingredients.Builder().setIngredientName("Flour").setIngredientType("Powder").setAmount(40);
        type0 = type1;
        assertEquals(type0, type1);
        System.out.println(" assert Equals");
    }
    @Test
    public void testIdentity() {
        Ingredients.Builder type0 = new Ingredients.Builder().setIngredientName("Cheese").setIngredientType("Solid").setAmount(80);
        Ingredients.Builder type1 = new Ingredients.Builder().setIngredientName("Cheese").setIngredientType("Solis").setAmount(80);
        type0 = type1;
        assertSame(type0, type1);
        System.out.print("assertSame");

    }
    @Test
    public void testTimeout() {
        AssertTimeout(3);
        System.out.println("Time out");
    }

    private void AssertTimeout(int i) {
    }

    @Test
    @Disabled(" When the timeout is exceeded")
    public void testWillBeExecuted() {
    }
}

