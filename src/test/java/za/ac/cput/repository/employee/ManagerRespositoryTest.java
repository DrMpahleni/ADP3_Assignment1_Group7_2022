package za.ac.cput.repository.employee;

/*
Author: Bongisa Mpahleni (216205999)
Date: 02 April 2022
*/

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Manager;
import za.ac.cput.factory.ManagerFactory;
import static org.junit.jupiter.api.Assertions.*;

class ManagerRespositoryTest {

    private static ManagerRespository managerRespository = ManagerRespository.getManagerRep();
    private static Manager manager= ManagerFactory.createManager(20,"jack","mpahleni","0781837656","21620599@gmail.com");

    @Test
    void create()
    {
        Manager created = managerRespository.create(manager);
        assertEquals(created.getManagerID(), manager.getManagerID());
        System.out.println("Created Repository: "+created);
    }

    @Test
    void read()
    {
        Manager read = managerRespository.read(manager.getManagerID());
        assertNotNull(read);
        System.out.println("Retrieved Repository: "+read);
    }

    @Test
    void update()
    {
        Manager update = new Manager.Builder().copy(manager).setFirstName("jackson").build();
        assertNotNull(managerRespository.update(update));
        System.out.println("Updated Repository: "+update);
    }

    @Test
    void delete()
    {
        boolean delete = managerRespository.delete(manager.getManagerID());
        assertTrue(delete);
        System.out.println("Deleted Repository: "+delete);
    }


    @Test
    void getAll()
    {
        System.out.println(" Display the equipment");
        assertEquals(1,managerRespository.getAll().size());
        System.out.println(managerRespository.getAll());

    }

}