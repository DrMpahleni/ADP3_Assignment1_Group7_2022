/*
    Chef.java
    Test for Chef
    Student:Hlumelo Mpotulo
    Student Number: 215226348
    Due Date 10 April 2022
 */
package za.ac.cput.entity;

import org.junit.jupiter.api.Test;

class ChefTest {
   @Test
   public void AddChefTest()
   {
       Chef chef = new Chef.Builder()
                           .setChefId(7658)
                           .setPositionId(5500)
                           .build();
       System.out.println(chef);

   }


}
