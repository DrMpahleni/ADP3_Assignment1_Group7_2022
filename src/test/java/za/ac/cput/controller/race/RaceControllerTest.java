package za.ac.cput.controller.race;

/*RaceControllerTest.java
  This is an Race Controller test case
  @Author: Lihle Njobe(218193882)
  Due date: 22 August 2022

 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.race.Race;
import za.ac.cput.service.race.RaceService;


import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RaceControllerTest {

    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired private RaceController controller;
    @Autowired private RaceService service;

    private Race race;
    private String baseUrl;

    @BeforeEach
    void setUp() {
        race = new Race.Builder()
                .setId(001)
                .setName("Caacasian")
                .build();

        this.baseUrl = "http:localhost:" + this.port + "restaurant/race/";
    }

    @Test
    void save() {
        String url = baseUrl + "save/";
        System.out.println(url);
        ResponseEntity<Race> response = this.restTemplate
                .postForEntity(url, this.race, Race.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    void read() {
        String url = baseUrl + "read/" + this.race.getId();
        System.out.println(url);
        ResponseEntity<Race> response = this.restTemplate.getForEntity(url,Race.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    void delete() {
        String url = baseUrl + "delete/" + this.race.getId();
        this.restTemplate.delete(url);
    }

    @Test
    void getAll() {
        String url = baseUrl + "all/";
        System.out.println(url);
        ResponseEntity<Race[]> response =
                this.restTemplate.getForEntity(url, Race[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertTrue(response.getBody().length == 1)
        );
    }


}

