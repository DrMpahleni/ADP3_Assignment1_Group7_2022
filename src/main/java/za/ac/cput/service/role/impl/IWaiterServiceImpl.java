/*
    IWaiterServiceImpl
    Student:Hlumelo Mpotulo
    Student Number: 215226348
    Due Date 26 October 2022
 */
package za.ac.cput.service.role.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.role.Waiter;
import za.ac.cput.repository.Waiter.WaiterRepository;
import za.ac.cput.service.role.IWaiterService;

import java.util.List;

@Service
public class IWaiterServiceImpl implements IWaiterService {

    @Autowired
    private WaiterRepository repository;

    @Override
    public Waiter save(Waiter waiter) {
        return repository.save(waiter);
    }

    @Override
    public Waiter find(int t) {
        return repository.findById(t).orElse(null);
    }

    @Override
    public Waiter update(Waiter waiter) {
        return repository.save(waiter);
    }

    @Override
    public boolean delete(int t) {
        Waiter delete = this.find(t);
        if(delete != null){
            repository.delete(delete);
            return true;
        }
        return false;
    }

    @Override
    public List<Waiter> findAll() {
        return repository.findAll();
    }
}
