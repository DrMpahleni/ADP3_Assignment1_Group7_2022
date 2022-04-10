/*
    Chef.java
    IRepository for Position
    Student:Hlumelo Mpotulo
    Student Number: 215226348
    Due Date 10 April 2022
 */
package za.ac.cput.repository;

import za.ac.cput.entity.Position;

import java.util.Set;

public interface IPositionRepository extends IRepository <Position,String> {

    Position read(int positionId);

    Position update(int positionId);

    Position delete(int positionId);

    Set<Position> getAll();
}
