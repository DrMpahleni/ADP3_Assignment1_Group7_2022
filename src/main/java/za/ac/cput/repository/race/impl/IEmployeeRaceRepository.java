package za.ac.cput.repository.race.impl;

/* IEmployeeRaceRepository.java
   This is a IEmployeeRace Repository class
   @Author: Lihle Njobe(21819388)
   Due date: 07 August 2022
 */


import za.ac.cput.domain.race.EmployeeRace;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface IEmployeeRaceRepository extends IRepository<EmployeeRace, Integer> {
    public Set<EmployeeRace> getAll();
}
