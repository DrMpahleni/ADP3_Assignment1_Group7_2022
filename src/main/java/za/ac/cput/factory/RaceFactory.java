package za.ac.cput.factory;

/*OrderFactory.java
Factory for Order
@author Lihle Njobe 218193882
Due date: 10 April 2022
*/

import za.ac.cput.entity.Race;
import za.ac.cput.util.genericHelper;

public class RaceFactory {

    public static Race createRace(String id, String name) {

        String ID = genericHelper.generateId();
        Race race = new Race.Builder().setId(ID).
                setName(name).
                build();
        return race;

    }
}
