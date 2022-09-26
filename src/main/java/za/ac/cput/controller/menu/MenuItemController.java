package za.ac.cput.controller.menu;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.menu.MenuItem;
import za.ac.cput.service.menu.MenuItemService;


import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(name ="restaurant/MenuItem/" )
@Slf4j
public class MenuItemController {

    @Autowired
    private MenuItemService menuItemService;

    @PostMapping("/create")
    public ResponseEntity<MenuItem> create  (@Valid @RequestBody MenuItem menuItem) {
        log.info("create  request: {}", menuItem);
        MenuItem save = menuItemService.create(menuItem);
        return ResponseEntity.ok(save);
    }
    @GetMapping("/read{id}")
    public Optional<MenuItem> read(@PathVariable Integer s ) {
        return menuItemService.read(s);
    }

    @PostMapping("/update")
    public MenuItem update(@PathVariable("menuItemID") MenuItem menuItem) {
        return menuItemService.update(menuItem);
    }
    @DeleteMapping("{menuItemID}")
    public void delete(@PathVariable("menuItemID") MenuItem s){
        menuItemService.delete(s);

    }

    @GetMapping("/getAll")
    public ResponseEntity<List<MenuItem>> getAll(Integer s) {
        List<MenuItem> menuItem = this.menuItemService.getAll(s);
        return ResponseEntity.ok(menuItem);
    }

}
