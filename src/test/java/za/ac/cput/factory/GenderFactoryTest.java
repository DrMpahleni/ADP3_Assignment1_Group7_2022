package za.ac.cput.factory;
/* GenderFactoryTest.java
 This is a Gender Factory Test Class
 Author: Vuyisa Nkangana(218192215)
 Due Date: 10 April 2022
  */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Gender;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class GenderFactoryTest {
    private Gender gend1;
    private Gender gend2;
    private Gender gend3;

    @BeforeEach
    void setUp() {
        Gender gend1 = new Gender.Builder().setId("Mav002").build();
        Gender gend2 = gend1;
    }

    @Test
    public void test() {

        Gender gender = GenderFactory.createGender("Mav002", "Vuyisa");
        System.out.println(gender.toString());
        assertNotNull(gender);
    }

    @Test
    public void testIdentity(){

        assertSame(gend1, gend2);
        System.out.println("Both Employee Genders are identical");
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

        assertEquals(gend1, gend2
        );
    }

}