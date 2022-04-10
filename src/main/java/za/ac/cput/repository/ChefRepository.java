/*
    Chef.java
    Repository for Chef
    Student:Hlumelo Mpotulo
    Student Number: 215226348
    Due Date 10 April 2022
 */

package za.ac.cput.repository;

import za.ac.cput.entity.Chef;

import java.util.HashSet;
import java.util.Set;

public class ChefRepository implements IChefRepository {

    private static ChefRepository repository = null;
    private Set <Chef> chefDB = null;

    private ChefRepository (){chefDB = new HashSet<>();
    }
    public static ChefRepository getRepository (){
        if (repository == null)
        {
            repository = new ChefRepository();
        }
        return repository;

    }
    @Override
   public Chef read(int chefId){
        for (Chef chef : this.chefDB){
            return chef;
        }
        return null;
    }

    @Override
    public Chef update(int chefId){
        Chef chef1 = read(Chef.getChefId());
        if (chef1 != null)
            this.chefDB.remove(chef1);
        this.chefDB.add(chef1);
        return chef1;
    }

    public Set<Chef> getAll () {
        return chefDB;
    }

    @Override
    public Chef create(Chef chef) {
        boolean success = chefDB.add(chef);
        if (! success)
        return null;
        return null;
    }

    @Override
    public Chef read(String s) {
        return null;
    }

    @Override
    public Chef update(Chef chef) {

        return null;
    }

@Override
public boolean delete(String s) {
  return false;
 }

    @Override
    public static Chef delete(int chefId) {
        Chef chefToRemove = read(chefId);
        if(chefToRemove == null);
        return null;
    }
}
