package za.ac.cput.factory.supplier;

/* Ingredients.java
   This is Ingredients factory class
   @Author: Lihle Njobe(218193882)
   Due date: 07 August 2022
 */

import za.ac.cput.domain.supplier.Ingredients;
import za.ac.cput.util.genericHelper;

public class IngredientsFactory {
    public static Ingredients createIngredients(String ingredientName, String ingredientType, int amount ) {
        if(genericHelper.isNullOrEmpty(ingredientName) || genericHelper.isNullOrEmpty(ingredientType))
            return null;

        Ingredients ingredients = new Ingredients.Builder().setIngredientName(ingredientName).
                setIngredientType(ingredientType).
                setAmount(amount).
                build();

        return ingredients;
    }
}
