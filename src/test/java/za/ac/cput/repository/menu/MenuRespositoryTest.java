package za.ac.cput.repository.menu;
/*
Author: Bongisa Mpahleni (216205999)
Date: 02 April 2022

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.menu.Menu;
import za.ac.cput.factory.menu.MenuFactory;
import static org.junit.jupiter.api.Assertions.*;

class MenuRespositoryTest {

    private static MenuRespository menuRespository = MenuRespository.getMenuRep();
    private static Menu menu=  MenuFactory.createMenu("dissert");

    @Test
    void create()
    {
        Menu created = menuRespository.create(menu);
        assertEquals(created.getMenuID(), menu.getMenuID());
        System.out.println("Created Repository: "+created);
    }

    @Test
    void read()
    {
        Menu read = menuRespository.read(menu.getMenuID());
        assertNotNull(read);
        System.out.println("Retrieved Repository: "+read);
    }

    @Test
    void update()
    {
        Menu update = new Menu.Builder().copy(menu).setName("stake").build();
        assertNotNull(menuRespository.update(update));
        System.out.println("Updated Repository: "+update);
    }

    @Test
    void delete()
    {
        boolean delete = menuRespository.delete(menu.getMenuID()) ;
        assertTrue(delete);
        System.out.println("Deleted Repository: "+delete);
    }


    @Test
    void getAll()
    {
        System.out.println(" Display the equipment");
        assertEquals(1,menuRespository.getAll().size());
        System.out.println(menuRespository.getAll());

    }

}
*/
