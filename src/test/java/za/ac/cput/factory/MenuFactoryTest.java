package za.ac.cput.factory;
/*
Author: Bongisa Mpahleni (216205999)
Date: 02 April 2022
*/
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.menu.Menu;
import za.ac.cput.factory.menu.MenuFactory;

import static org.junit.jupiter.api.Assertions.*;

class MenuFactoryTest {

    @Test
    public void createMenu() {
        Menu menu = MenuFactory.createMenu("bongisa");

        System.out.println(menu);

        assertTrue(menu instanceof Menu);
    }

}