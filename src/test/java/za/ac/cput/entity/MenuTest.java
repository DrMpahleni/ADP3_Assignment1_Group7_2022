package za.ac.cput.entity;

/*
Author: Bongisa Mpahleni (216205999)
Date: 02 April 2022
*/
import org.junit.jupiter.api.Test;
class MenuTest {

    @Test
    public void AddMenuTest()
    {
        Menu menu = new Menu.Builder()
                .setMenuID(1)
                .setName("seafood")
                .build();

        System.out.println(menu);

    }
}