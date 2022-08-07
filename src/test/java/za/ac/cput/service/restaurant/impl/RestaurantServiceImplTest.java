package za.ac.cput.service.restaurant.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.restaurant.Restaurant;
import za.ac.cput.service.restaurant.RestaurantService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RestaurantServiceImplTest {

    private final Restaurant restaurant = new Restaurant.Builder()
            .setName("Spur")
            .setAddress(".....")
            .setPhone(0215054545)
            .build();

    @Autowired private RestaurantService service;

    @Test
    void save() {
        Restaurant saved = service.save(restaurant);
        String output = String.valueOf(saved);
        assertAll(
                () -> assertNotNull(saved),
                () -> assertEquals(restaurant, output)
        );
        System.out.println(saved);
    }

    @Test
    void read() {
        Restaurant saved = service.save(restaurant);
        Optional<Restaurant> read = service.read(saved.getName());
        System.out.println(read);
        String output = String.valueOf(read.get());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(restaurant, output)
        );
    }

    @Test
    void delete() {
        this.service.delete(restaurant);
    }

    @Test
    void findByRestaurantName() {
        Restaurant saved = service.save(restaurant);
    }

}