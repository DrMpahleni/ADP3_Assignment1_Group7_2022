package za.ac.cput.service.Supplier;

/* IngredientsService.java
   This is Ingredients service class
   @Author: Lihle Njobe(218193882)
   Due date: 07 August 2022
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.supplier.Ingredients;
import za.ac.cput.repository.supplier.IngredientsRepository;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class IngredientsService implements IIngredientsService {
    private static IngredientsService service = null;

    @Autowired
    private IngredientsRepository repository;

    @Override
    public Ingredients create(Ingredients ingredients) {

        return this.repository.save(ingredients);
    }

    @Override
    public Optional<Ingredients> read(String ingredientName) {
        return Optional.ofNullable(this.repository.findById(ingredientName).orElse(null));
    }

    @Override
    public Ingredients update(Ingredients ingredients) {
        if (this.repository.existsById(ingredients.getIngredientName()))
            return this.repository.save(ingredients);
        return null;
    }

    @Override
    public void delete(Ingredients ingredients) {

    }

    @Override
    public Set<Ingredients> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Ingredients getIngredientsGiven(String ingredientName) {
        Ingredients i = null;
        Set<Ingredients> ingredient = getAll();
        for (Ingredients ingredients  : ingredient) {
            if (ingredients.getIngredientName().equals(ingredientName)) {
                i = ingredients;
                break;
            }
        }
        return i;
    }
}

