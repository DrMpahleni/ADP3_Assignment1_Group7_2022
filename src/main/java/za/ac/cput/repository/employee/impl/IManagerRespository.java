package za.ac.cput.repository.employee.impl;
/*
Author: Bongisa Mpahleni (216205999)
Date: 02 April 2022
*/
import za.ac.cput.entity.Manager;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface IManagerRespository extends IRepository<Manager, Integer> {
    public Set<Manager> getAll();
}
