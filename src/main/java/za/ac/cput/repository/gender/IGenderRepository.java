package za.ac.cput.repository.gender;

import za.ac.cput.entity.Gender;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface IGenderRepository extends IRepository<Gender, String> {
    public Set<Gender>getAll();

}
