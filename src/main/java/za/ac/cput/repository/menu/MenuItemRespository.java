package za.ac.cput.repository.menu;

import za.ac.cput.entity.MenuItem;
import za.ac.cput.repository.menu.impl.IMenuItemRespository;

import java.util.Set;
import java.util.HashSet;

public class MenuItemRespository implements IMenuItemRespository {

    private static MenuItemRespository menuItemRep = null;
    private Set<MenuItem> menuItemnSet;

    public MenuItemRespository() {
        this.menuItemnSet = new HashSet<>();
    }

    public static MenuItemRespository getMenuItemRep(){

        if(menuItemRep == null)
        {
            menuItemRep = new MenuItemRespository();
        }
        return menuItemRep;
    }


}
