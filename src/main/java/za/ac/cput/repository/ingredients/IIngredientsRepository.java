package za.ac.cput.repository.ingredients;

import za.ac.cput.entity.Employee;
import za.ac.cput.entity.Ingredients;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface IIngredientsRepository extends IRepository<Ingredients,String> {
    public Set<Ingredients> getAll();


}
