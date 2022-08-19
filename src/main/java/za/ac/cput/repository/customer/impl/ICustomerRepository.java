/*
ICustomerRepository.java
This is customer repository class.
Author: Felecia Zweni(218330189)
Date: August 2022
 */

package za.ac.cput.repository.customer.impl;

import za.ac.cput.domain.role.Customer;

import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface ICustomerRepository extends IRepository<Customer, String> {

    public Set<Customer> getAll();

}
