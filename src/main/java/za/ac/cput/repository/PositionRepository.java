/*
    Chef.java
    Repository for Position
    Student:Hlumelo Mpotulo
    Student Number: 215226348
    Due Date 10 April 2022
 */
package za.ac.cput.repository;

import za.ac.cput.entity.Position;

import java.util.HashSet;
import java.util.Set;

public class PositionRepository implements IPositionRepository {

    private static PositionRepository repository = null;
    private Set <Position> PositionDB = null;
    private Position Position;

    private PositionRepository () {
        PositionDB = new HashSet<>();
    }
    public static PositionRepository getRepository (){
        if (repository == null)
        {
            repository = new PositionRepository();
        }
        return repository;
    }
    @Override
    public Position create (Position position){
       for (Position positionA : this.PositionDB){
           return Position;
       }
       return null;
    }

    @Override
    public za.ac.cput.entity.Position read(String s) {
        return null;
    }

    @Override
    public za.ac.cput.entity.Position update(za.ac.cput.entity.Position position) {
        return null;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public Position read(int positionId){
        for (Position position: this.PositionDB){
            return position;
        }
        return null;
}

@Override
    public Position update(int positionId){
      Position positionA = read(Position.getPositionId());
      if (positionA != null);
      this.PositionDB.remove(positionA);
      this.PositionDB.add(positionA);
      return positionA;

}
@Override
    public static Position delete(int positionId){
        Position positionToRemove = read(positionId);
        if (positionToRemove == null)
            return null;
        PositionDB.remove(positionToRemove);
        return positionToRemove;
}
@Override
    public Set<Position> getAll(){
        return PositionDB;
}


}
