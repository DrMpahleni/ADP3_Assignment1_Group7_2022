/*
    Waiter.java
    Test for WaiterController
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
import za.ac.cput.domain.role.Waiter;
import za.ac.cput.factory.role.WaiterFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class WaiterControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/waiter";
    private static Waiter waiter = WaiterFactory.createWaiter(7784);

    @Test
    void a_save() {
        String url = BASE_URL + "/save";
        ResponseEntity<Waiter> postResponse = restTemplate.postForEntity(url, waiter, Waiter.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertEquals(HttpStatus.OK, postResponse.getStatusCode());
        waiter = postResponse.getBody();
        assertEquals(7784, postResponse.getBody().getPositionId());
        System.out.println("Created: " + postResponse.getBody());
    }

    @Test
    void b_find() {
        String url = BASE_URL + "/find/" + waiter.getWaiterId();
        System.out.println("URL: " + url);
        ResponseEntity<Waiter> response = restTemplate.getForEntity(url, Waiter.class);
        assertNotNull(response);
        assertNotNull(response.getBody());
        System.out.println("Read: " + response.getBody());
    }

    @Test
    void c_update() {
        Waiter update = new Waiter.Builder().copy(waiter).setPositionId(4499).build();
        String url = BASE_URL + "/update";
        ResponseEntity<Waiter> response = restTemplate.postForEntity(url, update, Waiter.class);
        assertNotNull(response);
        assertNotNull(response.getBody());
        System.out.println("Updated: " + response.getBody());
    }

    @Test
    @Disabled
    void delete() {
        String url = BASE_URL + "/delete/" + waiter.getWaiterId();
        restTemplate.delete(url);
        System.out.println("Deleted:" + waiter.getWaiterId() +"\nAt "+url);
    }

    @Test
    void findAll() {
        String url = BASE_URL + "/find-all";
        HttpHeaders header = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, header);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        assertNotNull(response);
        assertNotNull(response.getBody());
        System.out.println("GetAll: " + response.getBody());
    }
}