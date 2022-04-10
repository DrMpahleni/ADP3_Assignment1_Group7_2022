package za.ac.cput.repository.order;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.EmployeeRace;
import za.ac.cput.entity.Order;
import za.ac.cput.factory.OrderFactory;


import static org.junit.jupiter.api.Assertions.*;

class OrderRepositoryTest {
    private static OrderRepository repository = OrderRepository.getRepository();
    private static Order order = OrderFactory.createOrder(789, "pizza", "20,12,2021");

    @Test
    void a_create(){
        Order created = repository.create(order);
        assertEquals(created.getOrderId(), order.getOrderId());
        System.out.println("Create: "+ created);
    }

    @Test
    void b_read(){
        Order read = repository.read(order.getOrderId());
        assertNotNull(read);
        System.out.println("Read: "+ read);
    }

    @Test
    void c_update(){
        Order updated = new Order.Builder().copy(order).setOrderId("Indian").build();
        assertNotNull(repository.update(updated));
        System.out.println("Update: "+ updated);
    }

    @Test
    void d_delete(){
        boolean success = repository.delete(order.getOrderId());
        assertTrue(success);
        System.out.println("Delete: "+ success);
    }

    @Test
    void e_getAll(){
        System.out.println("Show all: ");
        System.out.println(repository.getAll());
    }
}



}