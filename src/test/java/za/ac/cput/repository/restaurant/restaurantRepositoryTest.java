/*
    restaurantRepositoryTest.java
    Repository test for restaurant
    Name: Ian Louw
    Student number: 216250773
 */

package za.ac.cput.repository.restaurant;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Restaurant;
import za.ac.cput.factory.RestaurantFactory;

import static org.junit.jupiter.api.Assertions.*;

class restaurantRepositoryTest {

    private static restaurantRepository repository = restaurantRepository.getRepository();
    private static Restaurant restaurant = RestaurantFactory.createRestaurant("Spur", "5656 Muizenberg", 0216667775);

    @Test
    void create() {
        Restaurant created = repository.create(restaurant);
        assertEquals(restaurant.getName(),created.getName());
        System.out.println("Create: " + created);
    }

    @Test
    void read() {
        Restaurant read = repository.read(restaurant.getName());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void update() {
        Restaurant updated = new Restaurant.Builder().copy(restaurant).setName("Tiger's Milk").build();
        assertNotNull(repository.update(updated));
        System.out.println("Update: " + updated);
    }

    @Test
    void delete() {
        boolean deleted = repository.delete(restaurant.getName());
        assertNotNull(deleted);
        System.out.println("Delete: " + deleted);
    }

    @Test
    void getAll() {
        System.out.println("Show all data: ");
        System.out.println(repository.getAll());
    }
}