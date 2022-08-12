package za.ac.cput.repository.customer.impl;

import za.ac.cput.domain.role.Customer;

import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface ICustomerRepository extends IRepository<Customer, String> {

    public Set<Customer> getAll();

}
