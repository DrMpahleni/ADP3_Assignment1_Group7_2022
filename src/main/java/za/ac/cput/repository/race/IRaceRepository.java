package za.ac.cput.repository.race;

import za.ac.cput.entity.Race;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface IRaceRepository extends IRepository<Race, String> {
    public Set<Race> getAll();
}
