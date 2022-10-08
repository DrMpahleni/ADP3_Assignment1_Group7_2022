package za.ac.cput.service.Supplier.impl;

/* IngredientsService.java
   This is Ingredients service class
   @Author: Lihle Njobe(218193882)
   Due date: 07 August 2022
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.supplier.Ingredients;
import za.ac.cput.repository.supplier.IngredientsRepository;
import za.ac.cput.service.Supplier.IIngredientsService;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class IngredientsServiceImpl implements IIngredientsService {
    private static IngredientsServiceImpl service = null;

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
        repository.delete(ingredients);

    }

    @Override
    public List<Ingredients> getAll(String ingredientName) {

        return repository.findAll();
    }

    @Override
    public void deleteById(String ingredientName) {
        Optional<Ingredients> ingredients = read(ingredientName);
        if (ingredients.isPresent()) delete(ingredients.get());


    }
}

