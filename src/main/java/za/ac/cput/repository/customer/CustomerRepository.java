/*
CustomerRepository.java
Author: Felecia Zweni (218330189)
Date: August 2022
 */



package za.ac.cput.repository.customer;
import za.ac.cput.domain.role.Customer;
import za.ac.cput.repository.customer.impl.ICustomerRepository;



import java.util.HashSet;
import java.util.Set;

public class CustomerRepository implements ICustomerRepository {

    private static CustomerRepository repository = null;
    private Set<Customer> customerDB = null;

    private CustomerRepository() {
        customerDB = new HashSet<Customer>();
    }

    public static CustomerRepository getRepository() {
        if (repository == null) {
            repository = new CustomerRepository();
        }
        return repository;
    }


    public Customer create(Customer customer) {
        boolean success = customerDB.add(customer);
        if (!success)
            return null;
        return customer;
    }

    @Override
    public Customer read(String s) {
        return null;
    }


    public Customer read(int customerId) {
        Customer customer = customerDB.stream()
                .filter(e -> e.getCustomerId().equals(customerId))
                .findAny()
                .orElse(null);
        return customer;
    }


    public Customer update(Customer customer){
        Customer oldCustomer = read(customer.getCustomerId());
        if(oldCustomer != null) {
            customerDB.remove(oldCustomer);
            customerDB.add(customer);
            return customer;
        }
        return null;
    }


    public boolean delete(String customerId) {
        Customer customerToDelete = read(customerId);
        if(customerToDelete == null)
            return false;
        customerDB.remove(customerToDelete);
        return true;
    }

    public Set<Customer> getAll(){
        return customerDB;
    }








}
