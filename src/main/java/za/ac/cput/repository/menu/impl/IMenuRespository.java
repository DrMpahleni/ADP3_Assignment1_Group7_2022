package za.ac.cput.repository.menu.impl;

/*
Author: Bongisa Mpahleni (216205999)
Date: 02 April 2022
*/
import za.ac.cput.entity.Menu;
import za.ac.cput.repository.IRepository;
import java.util.Set;

public interface IMenuRespository extends IRepository<Menu, Integer> {
public Set<Menu> getAll();
}
