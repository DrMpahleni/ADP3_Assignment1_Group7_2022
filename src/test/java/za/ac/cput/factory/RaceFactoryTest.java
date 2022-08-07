package za.ac.cput.factory;

/* RaceFactoryTest.java
   This is a Race factory test case class
   @Author: Lihle Njobe(21819388)
   Due date: 07 August 2022
 */

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.race.Race;
import za.ac.cput.factory.race.RaceFactory;

import static org.junit.jupiter.api.Assertions.*;

class RaceFactoryTest {

    @Test
    void createRace() {
        Race race = RaceFactory.createRace("White ") ;
        System.out.println(race.toString());
        assertNotNull(race);
    }

}