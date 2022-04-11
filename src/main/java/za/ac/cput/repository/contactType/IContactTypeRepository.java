package za.ac.cput.repository.contactType;
/* IEmployeeContactRepository.java
 This is a IEmployee Contact Repository Interface
 Author: Vuyisa Nkangana(218192215)
 Due Date: 10 April 2022
  */
import za.ac.cput.entity.ContactType;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface IContactTypeRepository extends IRepository<ContactType, String> {
    public Set<ContactType> getAll();
}
