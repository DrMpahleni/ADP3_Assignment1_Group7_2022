package za.ac.cput.service.menu.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.menu.MenuItem;
import za.ac.cput.repository.menu.impl.IMenuItemRespository;
import za.ac.cput.service.menu.MenuItemService;

import java.util.List;
import java.util.Optional;


@Service
public class MenuItemServiceImpl implements MenuItemService {

    private static MenuItemServiceImpl  service=null;
    private IMenuItemRespository repository;

    @Autowired
    public MenuItemServiceImpl(IMenuItemRespository repository) {
        this.repository = repository;
    }

    @Override
    public MenuItem create(MenuItem menuItem) {

        return this.repository.save(menuItem);
    }

    public Optional<MenuItem> read(Integer s) {
        return this.repository.findById(s);
    }


    @Override
    public MenuItem update(MenuItem menuItem) {
        if(this.repository.existsById(menuItem.getMenuItemID()))
            return this.repository.save(menuItem);
        return null;
    }

    @Override
    public void delete(MenuItem menuItem) {
            repository.delete(menuItem);
    }


    @Override
    public List<MenuItem> getAll(Integer MenuItemId) {
        return repository.findAll();
    }

    @Override
    public void deleteById(Integer menuItemId) {
        Optional<MenuItem> menuItem = read(menuItemId);
        if (menuItem.isPresent()) delete(menuItem.get());
    }
}
