package za.ac.cput.repository.ingredients;

/* IngredientsRepositoryTest.java
   This is Ingredients Repository Test case class
   @Author: Lihle Njobe(218193882)
   Due date: 07 August 2022
 */

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.domain.supplier.Ingredients;
import za.ac.cput.factory.supplier.IngredientsFactory;
import za.ac.cput.repository.supplier.IngredientsRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)

class IngredientsRepositoryTest {

    private final Ingredients ingredient1 = new Ingredients.Builder()
            .setIngredientName("Cheese ")
            .setIngredientType("Solid ")
            .setAmount(60)
            .build();

    @Autowired private IngredientsRepository repository;
    private static Ingredients ingredients = IngredientsFactory.createIngredients("Milk ", "Liquid ", 45);

    @Test
    void c_create() {
        Ingredients created = repository.save(ingredients);
        assertEquals(ingredients.getIngredientName(),created.getIngredientName());
        System.out.println("Created " + created);
    }
    @Test
    void r_read() {
        Ingredients read = repository.getById(ingredients.getIngredientName());
        assertNotNull(read);
        System.out.println("Read " + read);

    }
    @Test
    void u_update() {
        Ingredients updated = new Ingredients.Builder().copy(ingredients).setIngredientName("Butter")
                .setIngredientType("Solid")
                .setAmount(35)
                .build();
        assertNotNull(repository.save(updated));
        System.out.println(repository.getAll());
    }
    @Test
    void d_delete() {
        Ingredients saved = repository.save(ingredients);
        List<Ingredients> getAll = repository.findAll();
        repository.delete(saved);
        assertEquals(0, getAll.size());
    }
    @Test
    void e_getAll() {
        repository.save(ingredient1);
        List<Ingredients> getAll = repository.findAll();
        assertEquals(1, getAll.size());

    }



}