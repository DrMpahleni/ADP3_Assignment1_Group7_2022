package za.ac.cput.service.employeeGender.Impl;

/* EmployeeGenderServiceImpl.java
 This is a Employee Gender Service Class
 Author: Vuyisa Nkangana(218192215)
 Due Date: 7 August 2022
  */

import org.springframework.stereotype.Service;
import za.ac.cput.domain.contact.EmployeeContact;
import za.ac.cput.domain.gender.EmployeeGender;
import za.ac.cput.repository.employeeGender.EmployeeGenderRepository;
import za.ac.cput.service.employeeGender.IEmployeeGenderService;

import java.util.Optional;
import java.util.Set;
@Service
public class EmployeeGenderServiceImpl implements IEmployeeGenderService {
    private static EmployeeGenderServiceImpl employeeGender =null;
    private EmployeeGenderRepository employeeGenderRepository;

    public EmployeeGenderServiceImpl() {
        this.employeeGenderRepository = EmployeeGenderRepository.getRepository();
    }
    public static EmployeeGenderServiceImpl getEmployeeContact(){

        if (employeeGender == null) {
            employeeGender = new EmployeeGenderServiceImpl();
        }
        return employeeGender;
    }

    @Override
    public EmployeeGender create(EmployeeGender employeeGender) {
        return this.employeeGenderRepository.create(employeeGender);
    }

    @Override
    public Optional<EmployeeGender> read(String employeeId) {
        return Optional.ofNullable(this.employeeGenderRepository.read(employeeId));
    }

    @Override
    public EmployeeGender update(EmployeeGender employeeGender) {
        return this.employeeGenderRepository.update(employeeGender);
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
