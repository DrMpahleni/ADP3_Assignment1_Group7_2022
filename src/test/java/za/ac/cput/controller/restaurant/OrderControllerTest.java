package za.ac.cput.controller.restaurant;

/*OrderControllerTest.java
  This is order controller test
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
import za.ac.cput.domain.restaurant.Order;
import za.ac.cput.service.restaurant.OrderService;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class OrderControllerTest {

    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired private OrderController controller;
    @Autowired private OrderService service;

    private Order order;
    private String baseUrl;

    @BeforeEach
    void setUp() {
        order = new Order.Builder()
                .setOrderId(001)
                .setOrderItem("Pizza")
                .setAmount(50)
                .setDate("20/08/2022")
                .build();

        this.baseUrl = "http:localhost:" + this.port + "restaurant/order/";
    }

    @Test
    void save() {
        String url = baseUrl + "save/";
        System.out.println(url);
        ResponseEntity<Order> response = this.restTemplate
                .postForEntity(url, this.order, Order.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    void read() {
        String url = baseUrl + "read/" + this.order.getOrderId();
        System.out.println(url);
        ResponseEntity<Order> response = this.restTemplate.getForEntity(url,Order.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    void delete() {
        String url = baseUrl + "delete/" + this.order.getOrderId();
        this.restTemplate.delete(url);
    }

    @Test
    void getAll() {
        String url = baseUrl + "all/";
        System.out.println(url);
        ResponseEntity<Order[]> response =
                this.restTemplate.getForEntity(url, Order[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertTrue(response.getBody().length == 1)
        );
    }


}

