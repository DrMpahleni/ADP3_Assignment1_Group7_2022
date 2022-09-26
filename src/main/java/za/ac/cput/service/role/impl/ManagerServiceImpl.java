package za.ac.cput.service.role.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.role.Manager;
import za.ac.cput.repository.role.impl.IManagerRespository;
import za.ac.cput.service.role.ManagerService;

import java.util.List;
import java.util.Optional;

@Service
public class ManagerServiceImpl implements ManagerService {

    private static ManagerServiceImpl service=null;
    private IManagerRespository repository;

    @Autowired
    public ManagerServiceImpl(IManagerRespository repository) {
        this.repository = repository;
    }

    @Override
    public Manager create(Manager manager) {

        return this.repository.save(manager);
    }

    public Optional<Manager> read(Integer s) {
        return this.repository.findById(s);
    }


    @Override
    public Manager update(Manager manager) {
        if(this.repository.existsById(manager.getManagerID()))
            return this.repository.save(manager);
        return null;
    }

    @Override
    public void delete(Manager manager) {
        repository.delete(manager);
    }


    @Override
    public List<Manager> getAll(Integer managerId) {
        return repository.findAll();
    }

    @Override
    public void deleteById(Integer managerId) {
        Optional<Manager> manager = read(managerId);
        if (manager.isPresent()) delete(manager.get());
    }
}
