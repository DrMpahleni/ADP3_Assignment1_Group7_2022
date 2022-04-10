/*
    Chef.java
    Factory for Chef
    Student:Hlumelo Mpotulo
    Student Number: 215226348
    Due Date 10 April 2022
 */

package za.ac.cput.factory;

import za.ac.cput.entity.Chef;

public class ChefFactory {
    public static Chef createChef(
            int chefId,
            int positionId
    ){
        return new Chef.Builder().setChefId(chefId)
                                 .setPositionId(positionId)
                                 .build();
    }
}
