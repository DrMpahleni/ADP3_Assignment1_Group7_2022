package za.ac.cput.repository.menu.impl;

/*
Author: Bongisa Mpahleni (216205999)
Date: 02 April 2022
*/
import za.ac.cput.entity.MenuItem;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface IMenuItemRespository extends IRepository<MenuItem, Integer> {
    public Set<MenuItem> getAll();
}
