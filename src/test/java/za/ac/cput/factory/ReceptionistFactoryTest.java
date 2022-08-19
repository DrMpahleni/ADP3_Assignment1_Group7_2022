/*
ReceptionistFactoryTest.java
This is receptionist factory test class.
Author: Felecia Zweni(218330189)
Date: August 2022
 */

package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import za.ac.cput.domain.role.Receptionist;
import za.ac.cput.factory.role.ReceptionistFactory;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class ReceptionistFactoryTest {

    private Receptionist receptionist1, receptionist2;

    @BeforeEach
    void setUp(){
        Receptionist receptionist1 = new Receptionist.Builder().setReceptionId("1200").setPositionId(1201).build();
        Receptionist receptionist2  = receptionist1;
    }


    @Test
    public void test(){

        Receptionist receptionist = ReceptionistFactory.createReceptionist("1200", 1201);
        System.out.println(receptionist.toString());
        assertNotNull(receptionist);

    }

    @Test
    public void testEquality () {
        assertEquals(receptionist1, receptionist2);
        System.out.println("Both receptionists are equal");
    }

    @Test
    public void testIdentity(){

        assertSame(receptionist1, receptionist2);
        System.out.println("Both receptionists are identical");
    }

    @Test
    void testTimeout() {

        assertTimeout(Duration.ofMinutes(100), () -> {
            Thread.sleep(2000);

            System.out.println("Test Timed out");
        });
    }

    @Test
    @Disabled
    void testDisable() {

        assertEquals(receptionist1, receptionist2);
    }


}
