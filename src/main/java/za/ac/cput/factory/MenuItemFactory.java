package za.ac.cput.factory;

/* menuItemFactory.java
Author: Bongisa Mpahleni (216205999)
Date: 02 April 2022
*/

import za.ac.cput.entity.MenuItem;
import za.ac.cput.util.genericHelper;

public class MenuItemFactory {

    public static MenuItem createMenuItem(String portion,Double price) {

        int menuItemID = genericHelper.generatId();
        MenuItem menuItem= new MenuItem.Builder()
                .setMenuItemID(menuItemID)
                .setPortion(portion)
                .setPrice(price)
                .build();

        return menuItem;
    }
}
