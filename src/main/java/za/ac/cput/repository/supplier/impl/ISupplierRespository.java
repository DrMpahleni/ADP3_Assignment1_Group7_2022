package za.ac.cput.repository.supplier.impl;

/*
Author: Bongisa Mpahleni (216205999)
Date: 02 April 2022
*/

import za.ac.cput.entity.Supplier;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface ISupplierRespository extends IRepository<Supplier, Integer> {
    public Set<Supplier> getAll();
}
