/*
    Chef.java
    Test for Position
    Student:Hlumelo Mpotulo
    Student Number: 215226348
    Due Date 10 April 2022
 */
package za.ac.cput.domain;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.employee.Position;

class PositionTest {
    @Test
    public void AddPositionTest()
    {
        Position position = new Position.Builder()
                          .setPositionId(55001)
                          .setJobId(6656)
                          .setPositionName("Waitress")
                          .setPositionDescription("Serving clients at the front of the house")
                          .build();
        System.out.println(position);
    }


}

