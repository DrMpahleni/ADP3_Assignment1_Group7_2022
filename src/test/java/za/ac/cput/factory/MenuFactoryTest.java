package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Menu;

import static org.junit.jupiter.api.Assertions.*;

class MenuFactoryTest {

    @Test
    public void createMenu() {
        Menu menu = MenuFactory.createMenu("bongisa");

        System.out.println(menu);

        assertTrue(menu instanceof Menu);
    }

}