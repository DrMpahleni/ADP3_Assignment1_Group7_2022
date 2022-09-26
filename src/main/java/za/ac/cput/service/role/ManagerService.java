package za.ac.cput.service.role;



import za.ac.cput.domain.role.Manager;
import za.ac.cput.service.IService;

import java.util.List;

public interface ManagerService extends IService<Manager, Integer> {

    List<Manager> getAll(Integer ManagerId );
    void deleteById(Integer ManagerId);
}
