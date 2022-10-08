package za.ac.cput.controller.supplier;

/*IngredientsController.java
  This is an ingredients controller test case
  @Author: Lihle Njobe(218193882)
  Due date: 21 August 2022
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.supplier.Ingredients;
import za.ac.cput.service.Supplier.impl.IngredientsServiceImpl;


import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IngredientsControllerTest {

    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired private IngredientsController controller;
    @Autowired private IngredientsServiceImpl service;

    private Ingredients ingredients;
    private String baseUrl;

    @BeforeEach
    void setUp() {
        ingredients = new Ingredients.Builder()
                .setIngredientName("Bread")
                .setIngredientType("Solid")
                .setAmount(25)
                .build();

        this.baseUrl = "http:localhost:" + this.port + "restaurant/ingredients/";
    }

    @Test
    void save() {
        String url = baseUrl + "save/";
        System.out.println(url);
        ResponseEntity<Ingredients> response = this.restTemplate
                .postForEntity(url, this.ingredients, Ingredients.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    void read() {
        String url = baseUrl + "read/" + this.ingredients.getIngredientName();
        System.out.println(url);
        ResponseEntity<Ingredients> response = this.restTemplate.getForEntity(url,Ingredients.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    void delete() {
        String url = baseUrl + "delete/" + this.ingredients.getIngredientName();
        this.restTemplate.delete(url);
    }

    @Test
    void getAll() {
        String url = baseUrl + "all/";
        System.out.println(url);
        ResponseEntity<Ingredients[]> response =
                this.restTemplate.getForEntity(url, Ingredients[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertTrue(response.getBody().length == 1)
        );
    }


}
