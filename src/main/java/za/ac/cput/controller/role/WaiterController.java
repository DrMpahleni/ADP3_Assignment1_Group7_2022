/*
    WaiterController
    Student:Hlumelo Mpotulo
    Student Number: 215226348
    Due Date 26 October 2022
 */
package za.ac.cput.controller.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.role.Waiter;
import za.ac.cput.service.role.impl.IWaiterServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/waiter")
public class WaiterController {
    @Autowired
    private IWaiterServiceImpl service;

    @PostMapping("/save")
    public Waiter save(@RequestBody Waiter waiter) {
        return service.save(waiter);
    }

    @GetMapping("/find/{id}")
    public Waiter find(@PathVariable int id) {
        return service.find(id);
    }

    @PostMapping("/update")
    public Waiter update(@RequestBody Waiter waiter) {
        return service.update(waiter);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable int id) {
        return service.delete(id);
    }

    @GetMapping("/find-all")
    public List<Waiter> findAll() {
        return service.findAll();
    }
}
