package za.ac.cput.repository.menu;

/*
Author: Bongisa Mpahleni (216205999)
Date: 02 April 2022


import za.ac.cput.entity.MenuItem;
import za.ac.cput.repository.menu.impl.IMenuItemRespository;

import java.util.Set;
import java.util.HashSet;

public class MenuItemRespository implements IMenuItemRespository {

    private static MenuItemRespository menuItemRep = null;
    private Set<MenuItem> menuItemSet;

    public MenuItemRespository() {
        this.menuItemSet = new HashSet<>();
    }

    public static MenuItemRespository getMenuItemRep(){

        if(menuItemRep == null)
        {
            menuItemRep = new MenuItemRespository();
        }
        return menuItemRep;
    }
    @Override
   public MenuItem create(MenuItem menuItem)
    {
        boolean success = menuItemSet.add(menuItem);
        if(!success)
            return null;return menuItem;
    }

    @Override
    public MenuItem read(Integer menuItemID)
    {
        for(MenuItem item : menuItemSet) {
            if (item.getMenuItemID() == menuItemID) {
                return item;
            }
        }
            return null;
    }

    @Override
    public MenuItem update(MenuItem menuItem)
    {
        MenuItem _menuItem = read(menuItem.getMenuItemID());
        if(_menuItem != null)
        {
            menuItemSet.remove(_menuItem);
            menuItemSet.add(menuItem);
            return menuItem;
        }
        return null;
    }

    @Override
    public boolean delete(Integer menuItemID)
    {
        MenuItem delete = read(menuItemID);
      if(delete == null)
          return false;
        menuItemSet.remove(delete);
        return true;
    }

    @Override
    public Set<MenuItem> getAll() {
        return menuItemSet;
    }
}
*/

