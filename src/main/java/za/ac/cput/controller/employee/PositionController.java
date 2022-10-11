/*
    PositionController Class
    Student:Hlumelo Mpotulo
    Student Number: 215226348
    Due Date 26 October 2022
 */
package za.ac.cput.controller.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.employee.Position;
import za.ac.cput.service.employee.impl.IPositionServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/position")
public class
PositionController {
    @Autowired
    private IPositionServiceImpl service;

    @PostMapping("/save")
    public Position save(@RequestBody Position position) {
        return service.save(position);
    }

    @GetMapping("/find/{id}")
    public Position find(@PathVariable int id) {
        return service.find(id);
    }

    @PostMapping("/update")
    public Position update(@RequestBody Position position) {
        return service.update(position);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable int id) {
        return service.delete(id);
    }

    @GetMapping("/find-all")
    public List<Position> findAll() {
        return service.findAll();
    }
}
