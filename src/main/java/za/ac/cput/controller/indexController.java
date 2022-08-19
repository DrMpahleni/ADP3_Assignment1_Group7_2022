package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.domain.employee.Employee;

import javax.validation.Valid;

@RestController
@RequestMapping("index/")
@Slf4j
public class indexController {

    @PostMapping("employee")
    public String toEmployee (@Valid @ModelAttribute Employee employee) {
        return "forward:restaurant/employee/";
    }
}
