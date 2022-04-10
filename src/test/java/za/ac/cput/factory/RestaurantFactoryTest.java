/*
    RestaurantFactoryTest.java
    factory test for Restaurant
    Student: Ian Louw
    Student Number: 216250773
 */

package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Restaurant;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class RestaurantFactoryTest {

    private Restaurant res1;
    private Restaurant res2;

    @BeforeEach
    void setUp() {
        Restaurant res1 = new Restaurant.Builder().setName("Spur").build();
        Restaurant res2 = res1;
    }

    @Test
    public void test() {

        Restaurant restaurant = RestaurantFactory.createRestaurant("Restaurant ABC", "411 Long Street", 021333666);
        System.out.println(restaurant.toString());
        assertNotNull(restaurant);
    }

    @Test
    public void testEquality () {
        assertEquals(res1, res2);
        System.out.println("Both restaurants are equal");
    }

    @Test
    public void testIdentity(){

        assertSame(res1, res2);
        System.out.println("both restaurants are identical");
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

        assertEquals(res1, res2);
    }

}