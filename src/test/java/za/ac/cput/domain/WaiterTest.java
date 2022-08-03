/*
    Chef.java
    Test for Waiter
    Student:Hlumelo Mpotulo
    Student Number: 215226348
    Due Date 10 April 2022
 */
package za.ac.cput.domain;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.role.Waiter;

class WaiterTest {
  @Test
    public void AddWaiterTest(){
      Waiter waiter = new Waiter.Builder()
                     .setWaiterId(76)
                     .setPositionId(55001)
                     .build();
    System.out.println(waiter);
  }

}
