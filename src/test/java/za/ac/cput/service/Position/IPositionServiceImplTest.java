/*

    Test for IPositionServiceImpl
    Student:Hlumelo Mpotulo
    Student Number: 215226348
    Due Date 26 October 2022
 */

package za.ac.cput.service.Position;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.employee.Position;
import za.ac.cput.factory.employee.PositionFactory;
import za.ac.cput.service.employee.impl.IPositionServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class IPositionServiceImplTest {

    @Autowired
    private IPositionServiceImpl service;
    private static Position position = PositionFactory.createPosition("Manager", "Managing Staff", 505);

    @Test
    void a_save() {
        assertNotNull(service.save(position));
    }

    @Test
    void b_find() {
        assertEquals(505, service.find(position.getPositionId()).getJobId());
    }

    @Test
    void c_update() {
        Position n = new Position.Builder().copy(position).setPositionDescription("Commander").build();
        position = service.update(n);
        assertEquals("Commander", service.find(position.getPositionId()).getPositionDescription());
        System.out.println(position);
    }

    @Test
    @Disabled
    void e_delete() {
        assertTrue(service.delete(position.getPositionId()));
    }

    @Test
    void d_findAll() {
        assertEquals(1, service.findAll().size());
    }
}