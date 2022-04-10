/*
    Chef.java
    Factory for Chef
    Student:Hlumelo Mpotulo
    Student Number: 215226348
    Due Date 10 April 2022
 */
package za.ac.cput.factory;

import za.ac.cput.entity.Waiter;

public class WaiterFactory {
    public static Waiter createWaiter(
            int waiterId,
            int positionId
    ){
        return new Waiter.Builder().setWaiterId(waiterId)
                                   .setPositionId(positionId)
                                   .build();
    }

}
