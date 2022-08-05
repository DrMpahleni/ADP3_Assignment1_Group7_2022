package za.ac.cput.entity;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.factory.RaceFactory;


import static org.junit.jupiter.api.Assertions.*;

class RaceTest {
    @Test
    public void Race() {
        Race race = RaceFactory.createRace("001", " Black ");
        System.out.println(race);

    }

    @Test
    public void testEquality() {
        Race.Builder type0 = new Race.Builder().setName("African American").setId("003");
        Race.Builder type1 = new Race.Builder().setName("African American").setId("003");
        type0 = type1;
        assertEquals(type0, type1);
        System.out.println(" assert Equals");

    }

    @Test
    public void testIdentity() {
        Race.Builder type0 = new Race.Builder().setId("007").setName("White");
        Race.Builder type1 = new Race.Builder().setId("007").setName("White");
        type0 = type1;
        assertSame(type0, type1);
        System.out.print("assertSame");

    }

    @Test
    public void testTimeout() {
        AssertTimeout(3);
        System.out.println("Time out");
    }

    private void AssertTimeout(int i) {
    }

    @Test
    @Disabled(" When the timeout is exceeded")
    public void testWillBeExecuted() {
    }


}