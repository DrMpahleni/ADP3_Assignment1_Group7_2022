package za.ac.cput.repository.employeeGender;

import za.ac.cput.entity.EmployeeGender;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface IEmployeeGenderRepository extends IRepository<EmployeeGender, String> {
    public Set<EmployeeGender> getAll();
}
