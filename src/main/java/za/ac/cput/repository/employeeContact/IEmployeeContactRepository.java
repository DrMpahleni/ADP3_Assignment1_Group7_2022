package za.ac.cput.repository.employeeContact;

import za.ac.cput.entity.EmployeeContact;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface IEmployeeContactRepository extends IRepository<EmployeeContact, String> {
    public Set<EmployeeContact> getAll();
}
