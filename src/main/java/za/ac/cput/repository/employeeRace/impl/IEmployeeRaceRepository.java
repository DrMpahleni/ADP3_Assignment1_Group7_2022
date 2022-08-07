package za.ac.cput.repository.employeeRace.impl;

/* IEmployeeRaceRepository.java
   This is a IEmployeeRace Repository class
   @Author: Lihle Njobe(218193882)
   Due date: 07 August 2022
 */

import za.ac.cput.domain.race.EmployeeRace;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface IEmployeeRaceRepository extends IRepository<EmployeeRace, Integer> {
    public Set<EmployeeRace> getAll();
}
