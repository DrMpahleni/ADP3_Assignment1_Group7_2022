package za.ac.cput.controller.restaurant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.restaurant.Restaurant;
import za.ac.cput.service.restaurant.RestaurantService;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RestaurantControllerTest {

    @LocalServerPort private int port;
    @Autowired private TestRestTemplate restTemplate;
    @Autowired private RestaurantController controller;
    @Autowired private RestaurantService service;

    private Restaurant restaurant;
    private String baseUrl;

    @BeforeEach
    void setUp() {
        restaurant = new Restaurant.Builder()
                .setName("Spur")
                .setAddress("5555 long road")
                .setPhone(0215554545)
                .build();
        this.baseUrl = "http://localhost:" + this.port + "restaurant/";
    }

    @Test
    void save() {
        String url = baseUrl + "save/";
        System.out.println(url);
        ResponseEntity<Restaurant> response = this.restTemplate
                .postForEntity(url, this.restaurant, Restaurant.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    void read() {
        String url = baseUrl + "read/" + this.restaurant.getName();
        System.out.println(url);
        ResponseEntity<Restaurant> response = this.restTemplate.getForEntity(url, Restaurant.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    void delete() {
        String url = baseUrl + "delete/" + this.restaurant.getName();
        this.restTemplate.delete(url);
    }

    @Test
    void getAll() {
        String url = baseUrl + "all/";
        System.out.println(url);
        ResponseEntity<Restaurant[]> response =
                this.restTemplate.getForEntity(url, Restaurant[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertTrue(response.getBody().length == 1)
        );
    }
}