/*
    Chef.java
    Test for Chef
    Student:Hlumelo Mpotulo
    Student Number: 215226348
    Due Date 10 April 2022
 */
package za.ac.cput.domain;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.role.Chef;

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
