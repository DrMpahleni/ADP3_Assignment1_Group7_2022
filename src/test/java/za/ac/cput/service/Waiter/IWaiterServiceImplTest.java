package za.ac.cput.service.Waiter;
/*

    Test for IChefServiceImpl
    Student:Hlumelo Mpotulo
    Student Number: 215226348
    Due Date 26 October 2022
 */

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.role.Waiter;
import za.ac.cput.factory.role.WaiterFactory;
import za.ac.cput.service.role.impl.IWaiterServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class IWaiterServiceImplTest {

    @Autowired
    private IWaiterServiceImpl service;
    private static Waiter waiter = WaiterFactory.createWaiter(505);

    @Test
    void a_save() {
        assertNotNull(service.save(waiter));
    }

    @Test
    void b_find() {
        assertEquals(505, service.find(waiter.getWaiterId()).getPositionId());
    }

    @Test
    void c_update() {
        Waiter n = new Waiter.Builder().copy(waiter).setPositionId(888).build();
        waiter = service.update(n);
        assertTrue(waiter.getPositionId() == 888);
    }

    @Test
    @Disabled
    void e_delete() {
        assertTrue(service.delete(waiter.getWaiterId()));
    }

    @Test
    void d_findAll() {
        assertEquals(1, service.findAll().size());
    }
}