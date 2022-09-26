package za.ac.cput.controller.menu;


/* MenuFactory.java
Author: Bongisa Mpahleni (216205999)
Date: 02 April 2022
*/


import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.menu.Menu;
import za.ac.cput.service.menu.impl.MenuServiceImpl;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(name ="restaurant/Menu/" )
@Slf4j
public class MenuController {

    @Autowired
    private MenuServiceImpl menuService;

    @PostMapping("/create")
    public ResponseEntity<Menu> create  (@Valid @RequestBody Menu menu) {
        log.info("create  request: {}", menu);
        Menu save = menuService.create(menu);
        return ResponseEntity.ok(save);
    }
    @GetMapping("/read{id}")
    public Optional<Menu> read(@PathVariable Integer s ) {
        return menuService.read(s);
    }

    @PostMapping("/update")
    public Menu update(@PathVariable("menuID") Menu menu) {
        return menuService.update(menu);
    }
    @DeleteMapping("{menuID}")
    public void delete(@PathVariable("menuID") Menu s){
        menuService.delete(s);

    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Menu>> getAll(Integer s) {
        List<Menu> menu = this.menuService.getAll(s);
        return ResponseEntity.ok(menu);
    }

}
