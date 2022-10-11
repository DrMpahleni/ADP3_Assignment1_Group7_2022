/*
    IChefServiceImpl
    Student:Hlumelo Mpotulo
    Student Number: 215226348
    Due Date 26 October 2022
 */
package za.ac.cput.service.role.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.role.Chef;
import za.ac.cput.repository.Chef.ChefRepository;
import za.ac.cput.service.role.IChefService;

import java.util.List;

@Service
public class IChefServiceImpl implements IChefService {

    @Autowired
    private ChefRepository repository;

    @Override
    public Chef save(Chef chef) {
        return repository.save(chef);
    }

    @Override
    public Chef find(int t) {
        return repository.findById(t).orElse(null);
    }

    @Override
    public Chef update(Chef chef) {
        return repository.save(chef);
    }

    @Override
    public boolean delete(int t) {
        Chef delete = this.find(t);
        if(delete != null){
            repository.delete(delete);
            return true;
        }
        return false;
    }

    @Override
    public List<Chef> findAll() {
        return repository.findAll();
    }
}
