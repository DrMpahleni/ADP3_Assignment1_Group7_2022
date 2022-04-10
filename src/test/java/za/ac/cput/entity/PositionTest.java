/*
    Chef.java
    Test for Position
    Student:Hlumelo Mpotulo
    Student Number: 215226348
    Due Date 10 April 2022
 */
package za.ac.cput.entity;

import org.junit.jupiter.api.Test;

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

