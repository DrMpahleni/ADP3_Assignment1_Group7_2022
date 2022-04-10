/*
    Chef.java
    Test for Waiter
    Student:Hlumelo Mpotulo
    Student Number: 215226348
    Due Date 10 April 2022
 */
package za.ac.cput.entity;

import org.junit.jupiter.api.Test;

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
