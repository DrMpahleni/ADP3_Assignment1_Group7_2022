/*
    restaurantRepositoryTest.java
    Repository test for restaurant
    Name: Ian Louw
    Student number: 216250773
 */

package za.ac.cput.repository.restaurant;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.domain.restaurant.Restaurant;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class restaurantRepositoryTest {

    Restaurant restaurant1 = new Restaurant.Builder()
            .setName("Spur")
            .setAddress("5656 Muizenberg")
            .setPhone(0216667775)
            .build();
    @Autowired private RestaurantRepository repository;

    @Test
    void save() {
        Restaurant saved = repository.save(restaurant1);
        String output = String.valueOf(saved);
        assertNotNull(saved);
        assertSame(restaurant1, output);
    }

    @Test
    void read() {
        Restaurant saved = repository.save(restaurant1);
        Optional<Restaurant> read = repository.findById(saved.getName());
        String output = String.valueOf(read.get());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertSame(restaurant1, output)
        );
    }

    @Test
    void delete() {
        Restaurant saved = repository.save(restaurant1);
        List<Restaurant> getAll = repository.findAll();
        repository.delete(saved);
        assertEquals(0, getAll.size());
    }

    @Test
    void getAll() {
        repository.save(restaurant1);
        List<Restaurant> getAll = repository.findAll();
        assertEquals(1, getAll.size());
    }
}