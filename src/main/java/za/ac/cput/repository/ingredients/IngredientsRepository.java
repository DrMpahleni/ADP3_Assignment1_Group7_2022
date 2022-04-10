package za.ac.cput.repository.ingredients;

import za.ac.cput.entity.Ingredients;

import java.util.HashSet;
import java.util.Set;

public class IngredientsRepository implements IIngredientsRepository {

    private static IngredientsRepository repository = null;
    private Set<Ingredients> ingredientsDB = null;

    private IngredientsRepository() {

        ingredientsDB = new HashSet<Ingredients>();
    }

    public static IngredientsRepository getRepository() {
        if (repository == null) {
            repository = new IngredientsRepository();
        }
        return repository;
    }
    @Override
    public Ingredients create(Ingredients ingredients) {
        boolean success = ingredientsDB.add(ingredients);
        if(!success){
            return null;
        }
        return ingredients;
    }

    @Override
    public Ingredients read(String s) {
        for (Ingredients i : ingredientsDB) {
        }
        return null;
    }

    @Override
    public Ingredients update(Ingredients ingredients) {
        Ingredients oldIngredients = read(ingredients.getIngredientName());
        if(oldIngredients != null){
            ingredientsDB.remove(oldIngredients);
            ingredientsDB.add(ingredients);
            return ingredients;
        }

        return null;
    }

    @Override
    public boolean delete(String ingredientName) {
        Ingredients ingredientToDelete = read(ingredientName);
        if(ingredientToDelete == null){
            return false;
        }
        return true;
    }

    @Override
    public Set<Ingredients> getAll() {

        return null;
    }
}
