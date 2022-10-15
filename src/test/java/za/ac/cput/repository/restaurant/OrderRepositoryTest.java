package za.ac.cput.repository.restaurant;

/* OrderTest.java
   This is Order Repository Test case class
   @Author: Lihle Njobe(218193882)
   Due date: 07 August 2022
 */

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.domain.restaurant.Order;
import za.ac.cput.factory.restaurant.OrderFactory;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)

class OrderRepositoryTest {

    private final Order order1 = new Order.Builder()
            .setOrderId(67)
            .setOrderItem("Burger")
            .setDate("22/08/2022")
            .setAmount(150)
            .build();

    @Autowired
    private OrderRepository repository;
    private static Order order = OrderFactory.createOrder("Pizza");

    @Test
    void c_create() {
        Order created = repository.save(order);
        assertEquals(order.getOrderId(),created.getOrderItem());
        System.out.println("Created " + created);
    }
    @Test
    void r_read() {
        Order read = repository.getById(order.getOrderId());
        assertNotNull(read);
        System.out.println("Read " + read);

    }
    @Test
    void u_update() {
        Order updated = new Order.Builder().copy(order)
                .setOrderId(456)
                .setOrderItem("Steak ")
                .setDate("25/10/2022")
                .setAmount(345)
                .build();
        assertNotNull(repository.save(updated));
        System.out.println(repository.getAll());
    }
    @Test
    void d_delete() {
        Order saved = repository.save(order);
        List<Order> getAll = repository.findAll();
        repository.delete(saved);
        assertEquals(0, getAll.size());
    }
    @Test
    void e_getAll() {
        repository.save(order1);
        List<Order> getAll = repository.findAll();
        assertEquals(1, getAll.size());

    }


}