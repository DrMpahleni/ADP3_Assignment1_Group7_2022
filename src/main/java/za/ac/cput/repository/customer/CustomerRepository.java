/*
ICustomerRepository.java
This is customer repository class.
Author: Felecia Zweni(218330189)
Date: August 2022
 */

package za.ac.cput.repository.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.role.Customer;

import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface CustomerRepository extends JpaRepository<Customer, String> {

    public Set<Customer> getAll();

}
