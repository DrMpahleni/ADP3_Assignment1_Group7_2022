package za.ac.cput.service.menu;


import za.ac.cput.domain.menu.MenuItem;
import za.ac.cput.service.IService;

import java.util.List;

public interface MenuItemService extends IService<MenuItem, Integer> {

   List<MenuItem> getAll(Integer MenuItemId );
   void deleteById(Integer menuItemId);
}
