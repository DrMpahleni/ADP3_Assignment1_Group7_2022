package za.ac.cput.repository.ingredients;

/* IngredientsRepository.java
   This is an Ingredients Repository class
   @Author: Lihle Njobe(218193882)
   Due date: 07 August 2022
 */

import za.ac.cput.domain.supplier.Ingredients;
import za.ac.cput.repository.ingredients.impl.IIngredientsRepository;

import java.util.HashSet;
import java.util.Set;

public class IngredientsRepository implements IIngredientsRepository {

    private static IngredientsRepository repository = null;
    private Set<Ingredients> ingredientsDB = null;

    private IngredientsRepository() {
        ingredientsDB = new HashSet<>();
    }
    public static IngredientsRepository getRepository() {
        if(repository == null) {
            repository = new IngredientsRepository();
        }
        return repository;
    }

    @Override
    public Ingredients create(Ingredients ingredients) {
        boolean success = ingredientsDB.add(ingredients);
        if (!success)
            return null;
        return ingredients;
    }

    @Override
    public Ingredients read(String ingredientName) {

        Ingredients ingredients = ingredientsDB.stream()
                .filter(i -> i.getIngredientName() == ingredientName)
                .findAny()
                .orElse(null);
        return ingredients;
    }

    @Override
    public Ingredients update(Ingredients ingredients) {
        Ingredients oldIngredients = read(ingredients.getIngredientName());
        if (oldIngredients != null) {
            ingredientsDB.remove(oldIngredients);
            ingredientsDB.add(ingredients);
            return ingredients;
        }
        return null;
    }

    @Override
    public boolean delete(String ingredientName) {
        Ingredients ingredientsToDelete = read(ingredientName);
        if (ingredientsToDelete == null)
            return false;
        ingredientsDB.remove(ingredientsToDelete);
        return true;
    }

    @Override
    public Set<Ingredients> getAll() {
        return ingredientsDB;
    }
}
