/*
    Test for IChefServiceImpl
    Student:Hlumelo Mpotulo
    Student Number: 215226348
    Due Date 26 October 2022
 */

package za.ac.cput.service.Chef;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.role.Chef;
import za.ac.cput.factory.role.ChefFactory;
import za.ac.cput.service.role.impl.IChefServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class IChefServiceImplTest {

    @Autowired
    IChefServiceImpl service;

    private static Chef chef = ChefFactory.createChef(911);

    @Test
    void a_save() {
        Chef c = service.save(chef);
        assertTrue(c.getChefId() > 0);
        System.out.println(c);
    }

    @Test
    void b_find() {
        Chef c = service.find(chef.getChefId());
        assertNotNull(c);
        System.out.println(c);
    }

    @Test
    void c_update() {
        Chef n = new Chef.Builder().copy(chef).setPositionId(119).build();
        System.out.println("New Chef > " + n);
        chef = service.update(n);
        System.out.println("Updated >> " + chef);
    }

    @Test
    @Disabled
    void e_delete() {
        assertTrue(service.delete(chef.getChefId()));
        System.out.println(service.findAll());
    }

    @Test
    void d_findAll() {
        assertEquals(1, service.findAll().size());
        System.out.println(service.findAll());
    }
}