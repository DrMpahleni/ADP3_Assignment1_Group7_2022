package za.ac.cput.controller.supplier;

/*IngredientsControllerJava
  This is Ingredients controller
  @Author: Lihle Njobe(218193883)
  Due date: 21 August 2022
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.supplier.Ingredients;
import za.ac.cput.factory.supplier.IngredientsFactory;
import za.ac.cput.service.Supplier.IngredientsService;


import java.util.Optional;
import java.util.Set;

public class IngredientsController {

    @Autowired
    private IngredientsService ingredientsService;

    @PostMapping("/create")
    public Ingredients create(@RequestBody Ingredients ingredients) {
        Ingredients newIngredients = IngredientsFactory.createIngredients(ingredients.getIngredientName());

        return ingredientsService.create(newIngredients);
    }
    @GetMapping("/read{id}")
    public Optional<Ingredients> read(@PathVariable String ingredientName ) {
        return ingredientsService.read(ingredientName);
    }

    @PostMapping("/update")
    public Ingredients update(@RequestBody Ingredients ingredients) {
        return ingredientsService.update(ingredients);
    }
    @DeleteMapping("delete/{raceId}")
    public void delete(@PathVariable String ingredients){
        return;
    }

    @GetMapping("/getAll")
    public Set<Ingredients> getAll() {
        return ingredientsService.getAll();
    }

}

