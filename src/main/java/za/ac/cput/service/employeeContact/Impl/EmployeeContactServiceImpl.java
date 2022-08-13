package za.ac.cput.service.employeeContact.Impl;

/* EmployeeContactServiceImpl.java
 This is a Employee Contact Service Class
 Author: Vuyisa Nkangana(218192215)
 Due Date: 7 August 2022
  */

import za.ac.cput.domain.contact.EmployeeContact;
import za.ac.cput.repository.employeeContact.EmployeeContactRepository;
import za.ac.cput.service.employeeContact.IEmployeeContactService;

import java.util.Optional;
import java.util.Set;

public class EmployeeContactServiceImpl implements IEmployeeContactService {
    private static EmployeeContactServiceImpl employeeContact =null;
    private EmployeeContactRepository employeeContactRepository;

    public EmployeeContactServiceImpl() {
        this.employeeContactRepository = EmployeeContactRepository.getRepository();
    }
    public static EmployeeContactServiceImpl getEmployeeContact(){

        if (employeeContact == null) {
            employeeContact = new EmployeeContactServiceImpl();
        }
        return employeeContact;
    }

    @Override
    public EmployeeContact create(EmployeeContact employeeContact) {
        return this.employeeContactRepository.create(employeeContact);
    }

    @Override
    public Optional<EmployeeContact> read(String employeeId) {
        return Optional.ofNullable(this.employeeContactRepository.read(employeeId));
    }

    @Override
    public EmployeeContact update(EmployeeContact employeeContact) {
        return this.employeeContactRepository.update(employeeContact);
    }

    @Override
    public void delete(EmployeeContact employeeContact) {
    return;
    }

    @Override
    public Set<EmployeeContact> getAll() {
        return this.employeeContactRepository.getAll();
    }
}
