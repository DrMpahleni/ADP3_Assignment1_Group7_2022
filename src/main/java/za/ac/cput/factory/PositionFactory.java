/*
    Chef.java
    Factory for Chef
    Student:Hlumelo Mpotulo
    Student Number: 215226348
    Due Date 10 April 2022
 */
package za.ac.cput.factory;

import za.ac.cput.entity.Position;

public class PositionFactory {
    public static Position createPosition(
            int positionId,
            int jobId,
            String positionName,
            String positionDescription
    ){
        return new Position.Builder().setPositionId(positionId)
                                     .setJobId(jobId)
                                     .setPositionName(positionName)
                                     .setPositionDescription(positionDescription)
                                     .build();
    }
}
