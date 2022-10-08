/*
    IPositionServiceImpl
    Student:Hlumelo Mpotulo
    Student Number: 215226348
    Due Date 26 October 2022
 */
package za.ac.cput.service.employee.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.employee.Position;
import za.ac.cput.repository.Position.PositionRepository;
import za.ac.cput.service.employee.IPositionService;

import java.util.List;

@Service
public class IPositionServiceImpl implements IPositionService {

    @Autowired
    private PositionRepository repository;

    @Override
    public Position save(Position position) {
        return repository.save(position);
    }

    @Override
    public Position find(int t) {
        return repository.findById(t).orElse(null);
    }

    @Override
    public Position update(Position position) {
        return repository.save(position);
    }

    @Override
    public boolean delete(int t) {
        Position delete = this.find(t);
        if(delete != null){
            repository.delete(delete);
            return true;
        }
        return false;
    }

    @Override
    public List<Position> findAll() {
        return repository.findAll();
    }
}
