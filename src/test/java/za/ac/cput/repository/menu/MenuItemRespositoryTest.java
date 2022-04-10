package za.ac.cput.repository.menu;

/*
Author: Bongisa Mpahleni (216205999)
Date: 02 April 2022
*/

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.MenuItem;
import za.ac.cput.factory.MenuItemFactory;

import static org.junit.jupiter.api.Assertions.*;

class MenuItemRespositoryTest {

    private static MenuItemRespository menuItemRespository = MenuItemRespository.getMenuItemRep();
    private static MenuItem menuItem=  MenuItemFactory.createMenuItem("small",85.20);

    @Test
    void create()
    {
        MenuItem created = menuItemRespository.create(menuItem);
        assertEquals(created.getMenuItemID(), menuItem.getMenuItemID());
        System.out.println("Created Repository: "+created);
    }

    @Test
    void read()
    {
        MenuItem read = menuItemRespository.read(menuItem.getMenuItemID());
        assertNotNull(read);
        System.out.println("Retrieved Repository: "+read);
    }

    @Test
    void update()
    {
        MenuItem update = new MenuItem.Builder().copy(menuItem).setPortion("medium").build();
        assertNotNull(menuItemRespository.update(update));
        System.out.println("Updated Repository: "+update);
    }

    @Test
    void delete()
    {
        boolean delete = menuItemRespository.delete(menuItem.getMenuItemID()) ;
        assertTrue(delete);
        System.out.println("Deleted Repository: "+delete);
    }


    @Test
    void getAll()
    {
        System.out.println(" Display the equipment");
        assertEquals(1,menuItemRespository.getAll().size());
        System.out.println(menuItemRespository.getAll());

    }

}