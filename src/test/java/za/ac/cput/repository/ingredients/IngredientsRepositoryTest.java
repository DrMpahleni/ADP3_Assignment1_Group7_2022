package za.ac.cput.repository.ingredients;

/* IngredientsRepositoryTest.java
   This is Ingredients Repository Test case class
   @Author: Lihle Njobe(218193882)
   Due date: 07 August 2022
 */

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.supplier.Ingredients;
import za.ac.cput.factory.supplier.IngredientsFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)

class IngredientsRepositoryTest {
    private static IngredientsRepository repository = IngredientsRepository.getRepository();
    private static Ingredients ingredients = IngredientsFactory.createIngredients("Milk ", "Liquid ", 45);

    @Test
    void c_create() {
        Ingredients created = repository.create(ingredients);
        assertEquals(ingredients.getIngredientName(),created.getIngredientName());
        System.out.println("Created " + created);
    }
    @Test
    void r_read() {
        Ingredients read = repository.read(ingredients.getIngredientName());
        assertNotNull(read);
        System.out.println("Read " + read);

    }
    @Test
    void u_update() {
        Ingredients updated = new Ingredients.Builder().copy(ingredients).setIngredientName("Butter")
                .setIngredientType("Solid")
                .setAmount(35)
                .build();
        assertNotNull(repository.update(updated));
        System.out.println(repository.getAll());
    }
    @Test
    void d_delete() {
        boolean success = repository.delete(ingredients.getIngredientName());
        assertTrue(success);
        System.out.println("Ingredient deleted " + success);
    }
    @Test
    void e_getAll() {
        System.out.println("Get all ingredients");
        System.out.println(repository.getAll());
    }



}