package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Race;

import static org.junit.jupiter.api.Assertions.*;

class RaceFactoryTest {

    Race race1;
    Race race2;
    Race race3;


    @BeforeEach
    void setUp() {
        race1 = RaceFactory.createRace("23","African American" );
        race2 = RaceFactory.createRace("90", "Coloured");
        race3 = race1;
    }

    @Test
    public void testEquality(){
        assertEquals(race1, race3);
    }
    @Test
    public void testIdentity() {
        assertSame(race1, race3);
    }
    @Test
    public void timeoutTest(){
        Race race = RaceFactory.createRace("67", "Black");
        System.out.println(race);
    }
    @Test
    public void createRace(){
        Race race = RaceFactory.createRace("100", "Indian");
    }
}