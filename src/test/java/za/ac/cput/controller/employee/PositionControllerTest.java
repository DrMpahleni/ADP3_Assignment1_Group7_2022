/*
    Position.java
    Test for PositionController
    Student:Hlumelo Mpotulo
    Student Number: 215226348
    Due Date 26 October 2022
 */

package za.ac.cput.controller.employee;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.domain.employee.Position;
import za.ac.cput.factory.employee.PositionFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PositionControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/position";
    private static Position position = PositionFactory.createPosition("Developer", "Writing Code", 7754);

    @Test
    void a_save() {
        String url = BASE_URL + "/save";
        ResponseEntity<Position> postResponse = restTemplate.postForEntity(url, position, Position.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertEquals(HttpStatus.OK, postResponse.getStatusCode());
        position = postResponse.getBody();
        assertEquals("Developer", postResponse.getBody().getPositionName());
        System.out.println("Created: " + postResponse.getBody());
    }

    @Test
    void b_find() {
        String url = BASE_URL + "/find/" + position.getPositionId();
        System.out.println("URL: " + url);
        ResponseEntity<Position> response = restTemplate.getForEntity(url, Position.class);
        assertNotNull(response);
        assertNotNull(response.getBody());
        System.out.println("Read: " + response.getBody());
    }

    @Test
    void c_update() {
        Position update = new Position.Builder().copy(position).setPositionDescription("Commander").build();
        String url = BASE_URL + "/update";
        ResponseEntity<Position> response = restTemplate.postForEntity(url, update, Position.class);
        assertNotNull(response);
        assertNotNull(response.getBody());
        System.out.println("Updated: " + response.getBody());
    }

    @Test
    @Disabled
    void e_delete() {
        String url = BASE_URL + "/delete/" + position.getPositionId();
        restTemplate.delete(url);
        System.out.println("Deleted:" + position.getPositionId() + "\nAt " + url);
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