package za.ac.cput.service.employeeGender.Impl;

/* EmployeeGenderServiceImpl.java
 This is a Employee Gender Service Class
 Author: Vuyisa Nkangana(218192215)
 Due Date: 7 August 2022
  */

import org.springframework.stereotype.Service;
import za.ac.cput.domain.gender.EmployeeGender;
import za.ac.cput.repository.employeeContact.IEmployeeContactRepository;
import za.ac.cput.repository.employeeGender.IEmployeeGenderRepository;
import za.ac.cput.service.employeeGender.IEmployeeGenderService;

import java.util.Optional;
import java.util.Set;
@Service
public class EmployeeGenderServiceImpl implements IEmployeeGenderService {
    private IEmployeeGenderRepository employeeGenderRepository;

    public EmployeeGenderServiceImpl(IEmployeeGenderRepository employeeGenderRepository) {
        this.employeeGenderRepository = employeeGenderRepository;
    }

    public EmployeeGenderServiceImpl(){
    }

    @Override
    public EmployeeGender create(EmployeeGender employeeGender) {
        return employeeGenderRepository.save(employeeGender);
    }

    @Override
    public Optional<EmployeeGender> read(String employeeId) {
        return employeeGenderRepository.findById(employeeId);
    }

    @Override
    public EmployeeGender update(EmployeeGender employeeGender) {
        return employeeGenderRepository.save(employeeGender);
    }

    @Override
    public void delete(EmployeeGender employeeGender) {
    return;
    }

    @Override
    public Set<EmployeeGender> getAll() {
        return this.employeeGenderRepository.getAll();
    }

    @Override
    public void deleteById(String employeeId) {
        Optional<EmployeeGender> employeeGender = read(employeeId);
        if (employeeGender.isPresent()) delete(employeeGender.get());
    }
}
