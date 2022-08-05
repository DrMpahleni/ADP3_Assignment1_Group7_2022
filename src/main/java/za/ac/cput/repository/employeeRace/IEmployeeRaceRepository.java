package za.ac.cput.repository.employeeRace;

import za.ac.cput.entity.Employee;
import za.ac.cput.entity.EmployeeRace;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface IEmployeeRaceRepository extends IRepository<EmployeeRace, String> {

    public Set<EmployeeRace> getAll();
}

