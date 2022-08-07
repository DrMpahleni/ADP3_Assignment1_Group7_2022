package za.ac.cput.repository.order;

/* OrderRepositoryTest.java
   This is Order Repository Test case class
   @Author: Lihle Njobe(218193882)
   Due date: 07 August 2022
 */

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.restaurant.Order;
import za.ac.cput.factory.restaurant.OrderFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)

class OrderRepositoryTest {
    private static OrderRepository repository = OrderRepository.getRepository();
    private static Order order = OrderFactory.createOrder("Pizza ", "2022/08/06",100 );

    @Test
    void c_create() {
        Order created = repository.create(order);
        assertEquals(order.getOrderId(), created.getOrderId());
        System.out.println("Order created: " + created);
    }
    @Test
    void r_read() {
        Order read = repository.read(order.getOrderId());
        assertNotNull(read);
        System.out.println("Order " + read);
    }
    @Test
    void u_update() {
        Order updated = new Order.Builder().copy(order).setOrderId(123)
                .setOrderItem("Ribs ")
                .setDate("2022/08/06")
                .setAmount(150)
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Order updated " + updated);
    }
    @Test
    void d_delete() {
        boolean success = repository.delete(order.getOrderId());
        assertTrue(success);
        System.out.println("Order deleted " + success);
    }
    @Test
    void e_getAll() {
        System.out.println("Get all orders");
        System.out.println(repository.getAll());
    }


}