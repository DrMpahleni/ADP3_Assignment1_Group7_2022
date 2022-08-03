package za.ac.cput.factory;
/*
Author: Bongisa Mpahleni (216205999)
Date: 02 April 2022
*/
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.MenuItem;


import static org.junit.jupiter.api.Assertions.*;

class MenuItemFactoryTest {

    @Test
    public void createMenuItem() {
        MenuItem menuItem = MenuItemFactory.createMenuItem("small",20.2);

        System.out.println(menuItem);

        assertTrue(menuItem instanceof MenuItem);
    }
}