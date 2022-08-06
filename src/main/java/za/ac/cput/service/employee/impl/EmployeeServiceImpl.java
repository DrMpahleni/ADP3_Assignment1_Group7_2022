package za.ac.cput.service.employee.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.employee.Employee;
import za.ac.cput.repository.employee.EmployeeRepository;
import za.ac.cput.service.employee.EmployeeService;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository repository;

    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    public EmployeeServiceImpl() {

    }

    public Employee save (Employee employee) {
        return repository.save(employee);
    }

    public Optional<Employee> read (String employeeId) {
        return repository.findById(employeeId);
    }

    public void delete (Employee employee) {
        repository.delete(employee);
    }

    @Override
    public List<Employee> getAll(String employeeId){
        return repository.findAll();
    }


    public void deleteById(String employeeId) {
        Optional<Employee> employee = read(employeeId);
        if (employee.isPresent()) delete(employee.get());
    }
}
