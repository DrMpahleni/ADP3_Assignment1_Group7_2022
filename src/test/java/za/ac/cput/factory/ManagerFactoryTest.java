package za.ac.cput.factory;
/*
Author: Bongisa Mpahleni (216205999)
Date: 02 April 2022
*/
import za.ac.cput.domain.role.Manager;
import org.junit.jupiter.api.Test;
import za.ac.cput.factory.role.ManagerFactory;

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