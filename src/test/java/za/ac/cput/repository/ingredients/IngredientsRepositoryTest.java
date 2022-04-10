package za.ac.cput.repository.ingredients;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Ingredients;
import za.ac.cput.factory.IngredientsFactory;


import static org.junit.jupiter.api.Assertions.*;

class IngredientsRepositoryTest {
    private static IngredientsRepository repository = IngredientsRepository.getRepository();
    private static Ingredients ingredients = IngredientsFactory.createIngredients("Butter", " Solid", 20 );

    @Test
    void a_create(){
        Ingredients created = repository.create(ingredients);
        assertEquals(created.getIngredientName(), ingredients.getIngredientName());
        System.out.println("Create: "+ created);
    }

    @Test
    void b_read(){
        Ingredients read = repository.read(ingredients.getIngredientName());
        assertNotNull(read);
        System.out.println("Read: "+ read);
    }

    @Test
    void c_update(){
        Ingredients updated = new Ingredients.Builder().copy(ingredients).setIngredientName("Olive oil").build();
        assertNotNull(repository.update(updated));
        System.out.println("Update: "+ updated);
    }

    @Test
    void d_delete(){
        boolean success = repository.delete(ingredients.getIngredientName());
        assertTrue(success);
        System.out.println("Delete: "+ success);
    }

    @Test
    void e_getAll(){
        System.out.println("Show all: ");
        System.out.println(repository.getAll());
    }
}
