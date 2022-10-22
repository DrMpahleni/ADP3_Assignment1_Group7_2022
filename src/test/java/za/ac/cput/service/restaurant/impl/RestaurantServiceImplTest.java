package za.ac.cput.service.restaurant.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.restaurant.Payment;
import za.ac.cput.domain.restaurant.Restaurant;
import za.ac.cput.service.restaurant.RestaurantService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RestaurantServiceImplTest {

    private final Restaurant restaurant = new Restaurant.Builder()
            .setName("Spur")
            .setStreetAddress(".....")
            .setSuburb("Muizenberg")
            .setCity("Cape Town")
            .setProvince("Western Cape")
            .setZipCode(5100)
            .setPhone(0215054545)
            .build();

    @Autowired private RestaurantService service;

    @Test
    void save() {
        Restaurant saved = service.create(restaurant);
        String output = String.valueOf(saved);
        assertAll(
                () -> assertNotNull(saved),
                () -> assertEquals(restaurant, output)
        );
        System.out.println(saved);
    }

    @Test
    void read() {
        Restaurant saved = service.create(restaurant);
        Optional<Restaurant> read = service.read(saved.getName());
        System.out.println(read);
        String output = String.valueOf(read.get());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(restaurant, output)
        );
    }

    @Test
    void update() {
        Restaurant saved = service.create(restaurant);
        Restaurant updated = new Restaurant.Builder().copy(restaurant).setName("Quay4").build();
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    void delete() {
        this.service.delete(restaurant);
    }

    @Test
    void findByRestaurantName() {
        Restaurant saved = service.create(restaurant);
        String restaurantName = saved.getName();
        List<Restaurant> restaurantNameList = service.getAll(restaurantName);
        System.out.println(restaurantNameList);
        assertSame(1, restaurantNameList.size());
    }

}