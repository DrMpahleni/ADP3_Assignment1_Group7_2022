/*
    Chef.java
    Test for Waiter Repository
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

//import static org.junit.jupiter.api.AssertTrue.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WaiterRepositoryTest {
    private static IChefRepository chefRepository = ChefRepository.getRepository();
    private static Chef aChef = ChefFactory.createChef(5845,54545);

    @Test
    void getChefRepository (){

    }
    @Test
    void create(){
        Chef aChef1 = chefRepository.create(chefRepository.create(aChef));
        assertEquals(aChef.getPositionId(),aChef.getPositionId());
        System.out.println("created chef");
    }

    @Test
    void read(){
        Chef read = chefRepository.read(aChef.getPositionId());
        assertNotNull(read);
        System.out.println("\nRead:\n"+ read.toString());
    }
    @Test
    void update (){
        Chef aChef1 = new Chef.Builder().copy(aChef).setChefId(545)
                .setPositionId(5454)
                .build();
        aChef1=chefRepository.update(aChef1);
        System.out.println("\nUpdated:"+ aChef1);
    }
    @Test
    void delete(){
        Chef deleteSuccessful = chefRepository.delete(aChef.getPositionId());
        assertTrue ((BooleanSupplier) deleteSuccessful);

    }
    @Test
    void getAll(){
        System.out.println("\nDisplay All:" + chefRepository.getAll());
    }
}
