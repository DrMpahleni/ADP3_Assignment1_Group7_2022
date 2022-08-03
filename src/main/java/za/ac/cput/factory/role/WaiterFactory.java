/*
    Chef.java
    Factory for Chef
    Student:Hlumelo Mpotulo
    Student Number: 215226348
    Due Date 10 April 2022
 */
package za.ac.cput.factory.role;

import za.ac.cput.domain.role.Waiter;

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
