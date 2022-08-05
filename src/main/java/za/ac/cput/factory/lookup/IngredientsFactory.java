package za.ac.cput.factory.lookup;


/* IngredientsFactory.java
   This is Ingredients factory class
   @Author: Lihle Njobe(21819388)
   Due date: 07 August 2022
 */

import za.ac.cput.domain.lookup.Ingredients;
import za.ac.cput.util.genericHelper;

public class IngredientsFactory {
    public static Ingredients createIngredients(String ingredientName, String ingredientType, int amount) {
        if (genericHelper.isNullOrEmpty(ingredientName) || genericHelper.isNullOrEmpty(ingredientType))
            return null;

        Ingredients ingredients = new Ingredients.Builder().setIngredientName(ingredientName).
                setIngredientType(ingredientType).
                setAmount(amount).
                build();

        return ingredients;
    }
}
