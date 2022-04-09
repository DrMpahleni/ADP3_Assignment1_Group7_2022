package za.ac.cput.factory;

/*EmployeeRaceFactory.java
Factory for EmployeeRace
@author Lihle Njobe 218193882
Due date: 10 April 2022
*/

import za.ac.cput.entity.EmployeeRace;
import za.ac.cput.util.genericHelper;

public class EmployeeRaceFactory {

    public static EmployeeRace createEmployeeRace(int raceId, String raceName) {

        String raceID = genericHelper.generateId();
        EmployeeRace employeeRace = new EmployeeRace.Builder().setRaceId(raceID).
                setRaceName(raceName).
                build();

        return employeeRace;
    }
}


