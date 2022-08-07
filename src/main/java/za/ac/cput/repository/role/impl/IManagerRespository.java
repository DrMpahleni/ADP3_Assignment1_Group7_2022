package za.ac.cput.repository.role.impl;
/*
Author: Bongisa Mpahleni (216205999)
Date: 02 April 2022
*/

import org.springframework.stereotype.Repository;
import za.ac.cput.domain.role.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

@Repository
public interface IManagerRespository extends JpaRepository<Manager, Integer> {
    public Set<Manager> getAll();
}
