package za.ac.cput.factory;

/*IngredientsFactory.java
Factory for Ingredients
@author Lihle Njobe 218193882
Due date: 10 April 2022
*/

import za.ac.cput.entity.Ingredients;

public class  IngredientsFactory {

    public static Ingredients createIngredients(String ingredientName, String ingredientType, int amount) {
        Ingredients ingredients = new Ingredients.Builder()
                .setIngredientName(ingredientName)
                .setIngredientType(ingredientType)
                .setAmount(amount)
                .build();
        return ingredients;
    }
}


