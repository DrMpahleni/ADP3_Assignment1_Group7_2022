/*
    Chef.java
    Test for Position Repository
    Student:Hlumelo Mpotulo
    Student Number: 215226348
    Due Date 10 April 2022
 */
package za.ac.cput.domain;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.employee.Position;
import za.ac.cput.factory.employee.PositionFactory;
import za.ac.cput.repository.IPositionRepository;
import za.ac.cput.repository.PositionRepository;

import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.*;

public class PositionRepositoryTest {
    private static IPositionRepository positionRepository = PositionRepository.getRepository();
    private static Position aPosition1 = PositionFactory.createPosition(5845,54545,"Waiter","serving clients");

    @Test
    void getPositionRepository (){

    }
//    @Test
//    void create(){
//        Position aPosition = positionRepository.create(positionRepository.create(position));
//        assertEquals(aPosition.getPositionId(),aPosition.getPositionId());
//        System.out.println("created position");
//    }

    @Test
    void read(){
        Position read = positionRepository.read(aPosition1.positionId());
        assertNotNull(read);
        System.out.println("\nRead:\n"+ read.toString());
    }
    @Test
    void update (){
        Position aPosition = new Position.Builder().copy(aPosition1).setJobId(545)
                .setPositionId(5454)
                .build();
        aPosition=positionRepository.update(aPosition);
        System.out.println("\nUpdated:"+ aPosition);
    }
    @Test
    void delete(){
        Position deleteSuccessful = PositionRepository.delete(aPosition1.getPositionId());
        assertTrue ((BooleanSupplier) deleteSuccessful);

    }
    @Test
    void getAll(){
        System.out.println("\nDisplay All:" + positionRepository.getAll());
    }
}
