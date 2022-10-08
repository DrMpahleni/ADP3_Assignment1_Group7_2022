/*
    ChefController
    Student:Hlumelo Mpotulo
    Student Number: 215226348
    Due Date 26 October 2022
 */
package za.ac.cput.controller.role;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.role.Chef;
import za.ac.cput.service.role.impl.IChefServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/chef")
public class ChefController {

    @Autowired
    private IChefServiceImpl service;

    @PostMapping("/save")
    public Chef save(@RequestBody Chef chef) {
        return service.save(chef);
    }

    @GetMapping("/find/{id}")
    public Chef find(@PathVariable int id) {
        return service.find(id);
    }

    @PostMapping("/update")
    public Chef update(@RequestBody Chef chef) {
        return service.update(chef);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable int id) {
        return service.delete(id);
    }

    @GetMapping("/find-all")
    public List<Chef> findAll() {
        return service.findAll();
    }
}
