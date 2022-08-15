package za.ac.cput.service.restaurant;

/* OrderServiceTest.java
   This is Order service interface
   @Author: Lihle Njobe(218193882)
   Due date: 14 August 2022
 */

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.restaurant.Order;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderServiceTest {

    private final Order order = new Order.Builder()
            .setOrderId(236)
            .setOrderItem("Pizza")
            .setDate(" 14/08/2022")
            .setAmount(55)
            .build();

    @Autowired
    private OrderService service;

    @Test
    void create() {
        Order saved = service.create(order);
        String output = String.valueOf(saved);
        assertAll(
                () -> assertNotNull(saved),
                () -> assertEquals(order, output)
        );
        System.out.println(saved);
    }

    @Test
    void read() {
        Order saved = service.create(order);
        Optional<Order> read = service.read(saved.getOrderId());
        System.out.println(read);
        String output = String.valueOf(read.get());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(order, output)
        );
    }

    @Test
    void update () {
        Order saved = service.create(order);
        Order updated = new Order.Builder().copy(order).setOrderId(236).build();
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    void delete() {

        this.service.delete(order);
    }

    @Test
    void findByOrderId() {
        Order saved = service.create(order);
        Integer orderId = saved.getOrderId();
        List<Order> orderList = service.getAll(orderId);
        System.out.println(orderList);
        assertSame(1, orderList.size());
    }

}