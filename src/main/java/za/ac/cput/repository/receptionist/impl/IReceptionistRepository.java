package za.ac.cput.repository.receptionist.impl;

import za.ac.cput.entity.Receptionist;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface IReceptionistRepository extends IRepository<Receptionist, String> {
    public Set<Receptionist> getAll();
}
