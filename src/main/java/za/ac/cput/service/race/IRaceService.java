package za.ac.cput.service.race;

/*
IRaceService.java
@Author: Lihle Njobe(218193882)
Date: 07 August 2022
 */

import za.ac.cput.domain.race.Race;
import za.ac.cput.service.IService;

import java.util.List;
import java.util.Set;

public interface IRaceService extends IService<Race, Integer> {
    public Set<Race> getAll();
    public Race getEmployeeRaceGiven(String name);
    List<Race> getAll(Integer id);
}
