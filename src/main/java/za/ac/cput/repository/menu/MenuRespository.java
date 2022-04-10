package za.ac.cput.repository.menu;

/*
Author: Bongisa Mpahleni (216205999)
Date: 02 April 2022
*/
import za.ac.cput.entity.Menu;
import za.ac.cput.repository.menu.impl.IMenuRespository;


import java.util.HashSet;
import java.util.Set;

public class MenuRespository implements IMenuRespository {
    private static MenuRespository menuRep = null;
    private Set<Menu> menuSet;

    public MenuRespository() {
        this.menuSet = new HashSet<>();
    }

    public static MenuRespository getMenuRep(){

        if(menuRep == null)
        {
            menuRep = new MenuRespository();
        }
        return menuRep;
    }
    @Override
    public Menu create(Menu menu)
    {
        boolean success = menuSet.add(menu);
        if(!success)
            return null;return menu;
    }

    @Override
    public Menu read(Integer menuID)
    {
        for(Menu m : menuSet) {
            if (m.getMenuID() == menuID) {
                return m;
            }
        }
        return null;
    }

    @Override
    public Menu update(Menu menu)
    {
        Menu _menu = read(menu.getMenuID());
        if(_menu != null)
        {
            menuSet.remove(_menu);
            menuSet.add(menu);
            return menu;
        }
        return null;
    }

    @Override
    public boolean delete(Integer menuID)
    {
        Menu delete = read(menuID);
        if(delete == null)
            return false;
        menuSet.remove(delete);
        return true;
    }

    @Override
    public Set<Menu> getAll() {
        return menuSet;
    }
}
