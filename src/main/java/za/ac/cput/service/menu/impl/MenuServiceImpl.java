package za.ac.cput.service.menu.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.menu.Menu;
import za.ac.cput.repository.menu.impl.IMenuRespository;
import za.ac.cput.service.menu.MenuService;

import java.util.List;
import java.util.Optional;

@Service
public class MenuServiceImpl implements MenuService {

    private IMenuRespository repository;
    private static MenuServiceImpl  service=null;


    public MenuServiceImpl(IMenuRespository repository) {
        this.repository = repository;
    }

    public MenuServiceImpl() {

    }

    public Menu create (Menu menu) {
        return repository.save(menu);
    }

    public Optional<Menu> read (Integer menuID) {
        return repository.findById(menuID);
    }

    public Menu update(Menu menu) {
        return repository.save(menu);
    }

    public void delete (Menu menu) {
        repository.delete(menu);
    }


    public List<Menu> getAll(Integer menuID){
        return repository.findAll();
    }


    public void deleteById(Integer menuID) {
        Optional<Menu> menu = read(menuID);
        if (menu.isPresent()) delete(menu.get());
    }
}
