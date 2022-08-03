package za.ac.cput.entity;

/*
Author: Bongisa Mpahleni (216205999)
Date: 02 April 2022
*/

import org.junit.jupiter.api.BeforeEach;


class MenuItemTest {
    MenuItem menuItem;

    @BeforeEach
    void setUp() {
        menuItem = new MenuItem.Builder()
                .setPrice(28.20)
                .setPortion("large")
                .setMenuItemID(10)
                .build();

        System.out.println(menuItem);
    }


}