/*
ReceptionistControllerTest.java
This is receptionist controller test class.
Author: Felecia Zweni(218330189)
Date: August 2022
 */

package za.ac.cput.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.controller.role.ReceptionistController;
import za.ac.cput.domain.role.Receptionist;
import za.ac.cput.service.role.ReceptionistService;


import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ReceptionistControllerTest {

    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired private ReceptionistController controller;
    @Autowired private ReceptionistService service;

    private Receptionist receptionist;
    private String baseUrl;

    @BeforeEach
    void setUp() {
        receptionist  = new Receptionist.Builder()
                .setReceptionId("1200")
                .setPositionId(4)
                .build();
        this.baseUrl = "http://localhost:" + this.port + "role/receptionist";
    }

    @Test
    void save() {
        String url = baseUrl + "save/";
        System.out.println(url);
        ResponseEntity<Receptionist> response = this.restTemplate
                .postForEntity(url, this.receptionist, Receptionist.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    void read() {
        String url = baseUrl + "read/" + this.receptionist.getReceptionId();
        System.out.println(url);
        ResponseEntity<Receptionist> response = this.restTemplate.getForEntity(url, Receptionist.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    void delete() {
        String url = baseUrl + "delete/" + this.receptionist.getReceptionId();
        this.restTemplate.delete(url);
    }

    @Test
    void getAll() {
        String url = baseUrl + "all/";
        System.out.println(url);
        ResponseEntity<Receptionist[]> response =
                this.restTemplate.getForEntity(url, Receptionist[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertTrue(response.getBody().length == 1)
        );
    }
}
