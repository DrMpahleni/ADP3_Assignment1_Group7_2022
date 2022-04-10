package za.ac.cput.repository.customer;
import za.ac.cput.entity.Customer;
import za.ac.cput.repository.customer.impl.ICustomerRepository;
import za.ac.cput.repository.employee.employeeRepository;


import java.util.HashSet;
import java.util.Set;

public class customerRepository implements ICustomerRepository{

    private static customerRepository repository = null;
    private Set<Customer> customerDB = null;

    private customerRepository() {
        customerDB = new HashSet<Customer>();
    }

    public static customerRepository getRepository() {
        if (repository == null) {
            repository = new customerRepository();
        }
        return repository;
    }


    public Customer create(Customer customer) {
        boolean success = customerDB.add(customer);
        if (!success)
            return null;
        return customer;
    }


    public Customer read(String customerId) {
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
