/*
    Chef.java
    Test for ChefController
    Student:Hlumelo Mpotulo
    Student Number: 215226348
    Due Date 26 October 2022
 */

package za.ac.cput.controller;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.domain.role.Chef;
import za.ac.cput.factory.role.ChefFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ChefControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/chef";
    private static Chef chef = ChefFactory.createChef(663);

    @Test
    void a_save() {
        String url = BASE_URL + "/save";
        ResponseEntity<Chef> postResponse = restTemplate.postForEntity(url, chef, Chef.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertEquals(HttpStatus.OK, postResponse.getStatusCode());
        chef = postResponse.getBody();
        assertEquals(663, postResponse.getBody().getPositionId());
        System.out.println("Created: " + postResponse.getBody());
    }

    @Test
    void b_find() {
        String url = BASE_URL + "/find/" + chef.getChefId();
        System.out.println("URL: " + url);
        ResponseEntity<Chef> response = restTemplate.getForEntity(url, Chef.class);
        assertNotNull(response);
        assertNotNull(response.getBody());
        System.out.println("Read: " + response.getBody());
    }

    @Test
    void c_update() {
        Chef update = new Chef.Builder().copy(chef).setPositionId(3001).build();
        String url = BASE_URL + "/update";
        ResponseEntity<Chef> response = restTemplate.postForEntity(url, update, Chef.class);
        assertNotNull(response);
        assertNotNull(response.getBody());
        System.out.println("Updated: " + response.getBody());
    }

    @Test
    @Disabled
    void e_delete() {
        String url = BASE_URL + "/delete/" + chef.getChefId();
        restTemplate.delete(url);
        System.out.println("Deleted:" + chef.getChefId() + "\nAt " + url);
    }

    @Test
    void d_findAll() {
        String url = BASE_URL + "/find-all";
        HttpHeaders header = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, header);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        assertNotNull(response);
        assertNotNull(response.getBody());
        System.out.println("GetAll: " + response.getBody());
    }
}