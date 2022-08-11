package za.ac.cput.service.race;

/*
IEmployeeRaceService.java
@Author: Lihle Njobe(218193882)
Date: 07 August 2022
 */

import za.ac.cput.domain.race.EmployeeRace;
import za.ac.cput.service.IService;

import java.util.Set;

public interface IEmployeeRaceService extends IService<EmployeeRace, Integer> {
    public Set<EmployeeRace> getAll();
    public EmployeeRace getEmployeeRaceGiven(String raceName);
}

