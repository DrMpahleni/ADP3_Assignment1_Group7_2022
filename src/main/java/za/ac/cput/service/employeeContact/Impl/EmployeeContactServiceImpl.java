package za.ac.cput.service.employeeContact.Impl;

/* EmployeeContactServiceImpl.java
 This is a Employee Contact Service Class
 Author: Vuyisa Nkangana(218192215)
 Due Date: 7 August 2022
  */

import org.springframework.stereotype.Service;
import za.ac.cput.domain.contact.EmployeeContact;
import za.ac.cput.repository.contactType.IContactTypeRepository;
import za.ac.cput.repository.employeeContact.IEmployeeContactRepository;
import za.ac.cput.service.employeeContact.IEmployeeContactService;

import java.util.Optional;
import java.util.Set;
@Service
public class EmployeeContactServiceImpl implements IEmployeeContactService {
    private IEmployeeContactRepository employeeContactRepository;

    public EmployeeContactServiceImpl(IEmployeeContactRepository employeeContactRepository) {
        this.employeeContactRepository = employeeContactRepository;
    }

    public EmployeeContactServiceImpl(){
    }

    @Override
    public EmployeeContact create(EmployeeContact employeeContact) {
        return employeeContactRepository.save(employeeContact);
    }

    @Override
    public Optional<EmployeeContact> read(String employeeId) {
        return employeeContactRepository.findById(employeeId);
    }

    @Override
    public EmployeeContact update(EmployeeContact employeeContact) {
        return employeeContactRepository.save(employeeContact);
    }

    @Override
    public void delete(EmployeeContact employeeContact) {
    employeeContactRepository.delete(employeeContact);
    }

    @Override
    public Set<EmployeeContact> getAll() {
        return this.employeeContactRepository.getAll();
    }

    @Override
    public void deleteById(String employeeId) {
        Optional<EmployeeContact> employeeContact = read(employeeId);
        if (employeeContact.isPresent()) delete(employeeContact.get());
    }
}
