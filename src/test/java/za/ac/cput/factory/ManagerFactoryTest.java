package za.ac.cput.factory;

import za.ac.cput.entity.Manager;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;


class ManagerFactoryTest {
    @Test
    public void createManager() {
        Manager manager = ManagerFactory.createManager(20, "bongisa", "Mpahleni",
                "0781837656", "@gmail.com");

        System.out.println(manager);

        assertTrue(manager instanceof Manager);
    }
}