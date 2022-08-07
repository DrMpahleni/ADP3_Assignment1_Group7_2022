package za.ac.cput.repository.menu.impl;

/*
Author: Bongisa Mpahleni (216205999)
Date: 02 April 2022
*/
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.menu.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Set;

@Repository
public interface IMenuRespository extends JpaRepository<Menu, Integer> {
public Set<Menu> getAll();
}
