/*
    Chef.java
    Repository for Waiter
    Student:Hlumelo Mpotulo
    Student Number: 215226348
    Due Date 10 April 2022
 */
package za.ac.cput.repository;

import za.ac.cput.entity.Waiter;

import java.util.HashSet;
import java.util.Set;

public class WaiterRepository implements IWaiterRepository {
    private static WaiterRepository repository = null;
    private Set<Waiter> waiterDB = null;

    private WaiterRepository (){
        waiterDB= new HashSet<>();

        }
        public static WaiterRepository getRepository(){
        if(repository == null){
            repository = new WaiterRepository();
        }
        return repository;
    }
    @Override

    public Waiter create(Waiter waiter){
        boolean success = waiterDB.add(waiter);
        if (!success)
            return null;
        return null;
    }

    @Override
    public Waiter read(String s) {
        return null;
    }

    @Override
    public Waiter update(Waiter waiter) {
        return null;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public Waiter delete(int waiterId) {
        Waiter waiterToRemove = read(waiterId);
        if (waiterToRemove == null);
        return null;
    }

    @Override
    public Waiter read(int waiterId){
        for (Waiter waiter : this.waiterDB){
            return waiter;
        }
        return null;
    }


    @Override
   public Set<Waiter>
    getAll()
    {
        return waiterDB;
    }
}
