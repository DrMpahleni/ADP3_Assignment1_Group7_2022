/*
    Chef.java
    Test for Chef Repository
    Student:Hlumelo Mpotulo
    Student Number: 215226348
    Due Date 10 April 2022
 */
package za.ac.cput.domain;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.role.Chef;
import za.ac.cput.factory.role.ChefFactory;
import za.ac.cput.repository.ChefRepository;
import za.ac.cput.repository.IChefRepository;


import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.*;

public class ChefRepositoryTest {

    private static IChefRepository chefRepository = ChefRepository.getRepository();
    private static za.ac.cput.domain.role.Chef aChef = ChefFactory.createChef(5845,54545);
    private Chef Chef;

    @Test
    void getPositionRepository (){

    }
    @Test 
    void create () {
        Chef aChef = chefRepository.create(chefRepository.create(Chef));
        assertEquals(aChef.getPositionId(), aChef.getPositionId());
    }
    @Test
    void read (){
        Chef read = chefRepository.read(aChef.getPositionId());
        assertNotNull(read);
        System.out.println("\nRead:\n"+ read.toString());
    }
    @Test
    void update (){
        Chef aChef = new Chef.Builder().copy(aChef).setChefId(545)
                .setPositionId(5454)
                .build();
        aChef=chefRepository.update(aChef);
        System.out.println("\nUpdated:"+ aChef);
    }
    @Test
    void delete(){
        Chef deleteSuccessful = ChefRepository.delete(aChef.getPositionId());
        assertTrue ((BooleanSupplier) deleteSuccessful);

    }
    @Test
    void getAll(){
        System.out.println("\nDisplay All:" + chefRepository.getAll());
    }

}
   


