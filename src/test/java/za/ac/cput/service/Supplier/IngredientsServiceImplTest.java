package za.ac.cput.service.Supplier;
/* IngredientsServiceTest.java
   This is Ingredients test class
   @Author: Lihle Njobe(218193882)
   Due date: 14 August 2022
 */
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.domain.supplier.Ingredients;
import za.ac.cput.service.Supplier.impl.IngredientsServiceImpl;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class IngredientsServiceImplTest {

    private final Ingredients ingredients = new Ingredients.Builder()
            .setIngredientName("Isinkwa")
            .setIngredientType("Solid")
            .setAmount(22)
            .build();

    @Autowired
    private IngredientsServiceImpl service;

    @Test
    void create() {
        Ingredients saved = service.create(ingredients);
        String output = String.valueOf(saved);
        assertAll(
                () -> assertNotNull(saved),
                () -> assertEquals(ingredients, output)
        );
        System.out.println(saved);
    }

    @Test
    void read() {
        Ingredients saved = service.create(ingredients);
        Optional<Ingredients> read = service.read(saved.getIngredientName());
        System.out.println(read);
        String output = String.valueOf(read.get());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(ingredients, output)
        );
    }

    @Test
    void update () {
        Ingredients saved = service.create(ingredients);
        Ingredients updated = new Ingredients.Builder().copy(ingredients).setIngredientName("Shizi").build();
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    void delete() {

        this.service.delete(ingredients);
    }

    @Test
    void getIngredientGiven() {
        Ingredients saved = service.create(ingredients);
        String ingredientName = saved.getIngredientName();
        List<Ingredients> ingredientsList = service.getAll(ingredientName);
        System.out.println(ingredientsList);
        assertSame(1, ingredientsList.size());
    }

}