package za.ac.cput.repository.gender;
/* IGenderRepository.java
        This is a IGender Repository Interface
        Author: Vuyisa Nkangana(218192215)
        Due Date: 10 April 2022
        */
import za.ac.cput.entity.Gender;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface IGenderRepository extends IRepository<Gender, String> {
    public Set<Gender> getAll();
}
