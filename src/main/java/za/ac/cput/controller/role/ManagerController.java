package za.ac.cput.controller.role;

   /* MenuFactory.java
Author: Bongisa Mpahleni (216205999)
Date: 02 April 2022
*/

import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.role.Manager;
import za.ac.cput.service.role.impl.ManagerServiceImpl;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(name ="restaurant/Manager/" )
@Slf4j
public class ManagerController {

    @Autowired
    private ManagerServiceImpl ManagerService;

    @PostMapping("/create")
    public ResponseEntity<Manager> create  (@Valid @RequestBody Manager manager) {
        log.info("create  request: {}", manager);
        Manager save = ManagerService.create(manager);
        return ResponseEntity.ok(save);
    }
    @GetMapping("/read{id}")
    public Optional<Manager> read(@PathVariable Integer s ) {
        return ManagerService.read(s);
    }

    @PostMapping("/update")
    public Manager update(@PathVariable("managerId") Manager manager) {
        return ManagerService.update(manager);
    }
    @DeleteMapping("{managerId}")
    public void delete(@PathVariable("managerId") Manager s){
        ManagerService.delete(s);

    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Manager>> getAll(Integer s) {
        List<Manager> menu = this.ManagerService.getAll(s);
        return ResponseEntity.ok(menu);
    }

}
