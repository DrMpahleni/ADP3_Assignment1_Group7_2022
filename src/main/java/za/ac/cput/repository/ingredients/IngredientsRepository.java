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
        return null;
    }

    @Override
    public Ingredients read(String s) {
        return null;
    }

    @Override
    public Ingredients update(Ingredients ingredients) {
        return null;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public Set<Ingredients> getAll() {
        return null;
    }
}
