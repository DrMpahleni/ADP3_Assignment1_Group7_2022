package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.MenuItem;
import za.ac.cput.entity.MenuItem;

import static org.junit.jupiter.api.Assertions.*;

class MenuItemFactoryTest {

    @Test
    public void createMenuItem() {
        MenuItem menuItem = MenuItemFactory.createMenuItem(20,20.2);

        System.out.println(menuItem);

        assertTrue(menuItem instanceof MenuItem);
    }
}