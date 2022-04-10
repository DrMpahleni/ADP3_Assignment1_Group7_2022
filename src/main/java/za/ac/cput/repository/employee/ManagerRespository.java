package za.ac.cput.repository.employee;

/*
Author: Bongisa Mpahleni (216205999)
Date: 02 April 2022
*/
import za.ac.cput.entity.Manager;
import za.ac.cput.repository.employee.impl.IManagerRespository;
import java.util.HashSet;
import java.util.Set;


public class ManagerRespository implements IManagerRespository {

    private static ManagerRespository managerRep = null;
    private Set<Manager> managerSet;

    public ManagerRespository() {
        this.managerSet = new HashSet<>();
    }

    public static ManagerRespository getManagerRep(){

        if(managerRep == null)
        {
            managerRep = new ManagerRespository();
        }
        return managerRep;
    }
    @Override
    public Manager create(Manager manager)
    {
        boolean success = managerSet.add(manager);
        if(!success)
            return null;return manager;
    }

    @Override
    public Manager read(Integer managerID)
    {
        for(Manager manager : managerSet) {
            if (manager.getManagerID() == managerID) {
                return manager;
            }
        }
        return null;
    }

    @Override
    public Manager update(Manager manager)
    {
        Manager _manager = read(manager.getManagerID());
        if(_manager != null)
        {
            managerSet.remove(_manager);
            managerSet.add(manager);
            return manager;
        }
        return null;
    }

    @Override
    public boolean delete(Integer managerID)
    {
        Manager delete = read(managerID);
        if(delete == null)
            return false;
        managerSet.remove(delete);
        return true;
    }

    @Override
    public Set<Manager> getAll() {
        return managerSet;
    }

}
