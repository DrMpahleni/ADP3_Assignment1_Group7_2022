/*
    EmployeeController.java
    Controller for Employee
    Student: Ian Louw
    Student Number: 216250773
 */

package za.ac.cput.controller.employee;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.employee.Employee;
import za.ac.cput.service.employee.EmployeeService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("restaurant/employee/")
@Slf4j
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired public EmployeeController (EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("save")
    public ResponseEntity<Employee> save (@Valid @RequestBody Employee employee) {
        log.info("Save request: {}", employee);
        Employee save = employeeService.create(employee);
        return ResponseEntity.ok(save);
    }

    private Optional<Employee> getById(String employeeId) {
        return this.employeeService.read(employeeId);
    }

    @GetMapping("read/{employeeId}")
    public ResponseEntity<Employee> read (@PathVariable String employeeId) {
        log.info("Read request: {}", employeeId);
        Employee employee = getById(employeeId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(employee);
    }

    @PutMapping("update")
    public ResponseEntity<Employee> update (@Valid @RequestBody Employee employee) {
        log.info("Update request: {}", employee);
        Employee updated = employeeService.update(employee);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Void> delete(@PathVariable String employeeId) {
        log.info("Read request: {}", employeeId);
        this.employeeService.deleteById(employeeId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Employee>> getAll(String employeeId) {
        List<Employee> employees = this.employeeService.getAll(employeeId);
        return ResponseEntity.ok(employees);
    }
}
