package za.ac.cput.controller.race;

/*EmployeeRaceControllerTest.java
  This is an EmployeeRace Controller test case
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
import za.ac.cput.domain.race.EmployeeRace;
import za.ac.cput.service.race.EmployeeRaceService;


import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EmployeeRaceControllerTest {

    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired private EmployeeRaceController controller;
    @Autowired private EmployeeRaceService service;

    private EmployeeRace employeeRace;
    private String baseUrl;

    @BeforeEach
    void setUp() {
        employeeRace = new EmployeeRace.Builder()
                .setRaceId(001)
                .setRaceName("Caacasian")
                .build();

        this.baseUrl = "http:localhost:" + this.port + "restaurant/employeeRace/";
    }

    @Test
    void save() {
        String url = baseUrl + "save/";
        System.out.println(url);
        ResponseEntity<EmployeeRace> response = this.restTemplate
                .postForEntity(url, this.employeeRace, EmployeeRace.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    void read() {
        String url = baseUrl + "read/" + this.employeeRace.getRaceId();
        System.out.println(url);
        ResponseEntity<EmployeeRace> response = this.restTemplate.getForEntity(url, EmployeeRace.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    void delete() {
        String url = baseUrl + "delete/" + this.employeeRace.getRaceId();
        this.restTemplate.delete(url);
    }

    @Test
    void getAll() {
        String url = baseUrl + "all/";
        System.out.println(url);
        ResponseEntity<EmployeeRace[]> response =
                this.restTemplate.getForEntity(url, EmployeeRace[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertTrue(response.getBody().length == 1)
        );
    }


}