package za.ac.cput.repository.table.impl;

import za.ac.cput.entity.Table;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface ITableRepository extends IRepository<Table, String> {
    public Set<Table> getAll();
}
